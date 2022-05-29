import libs.MemoryUsageSensor;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Christopher Liudahl-Rackley
 * 5/28/2022
 * CS410-Software Engineering
 * <p>
 * This is the MemoryAdaptor class that implements all of the methods of the
 * Sensor interface. It does this by setting the value of the getter methods
 * from the MemoryUsageSensor library to the values of the instances of the
 * Adaptor class. By using this Adaptor Design Pattern we can hide the implementation
 * of the methods in the library, preventing any changes of the library to occur.
 * Then we can instantiate this Adaptor class in the client, and use all of the
 * libraries methods.
 */

class MemoryAdaptor implements Sensor {
    private String memTitle;
    private double memValue;
    private String memReport;

    /**
     * MemoryAdaptor Constructor with no params
     * Allocated memory from the MemoryUsageSensor library and sets
     * all of the class variables to the values of the getter methods
     * from the library.
     */
    public MemoryAdaptor() {
        MemoryUsageSensor mem = new MemoryUsageSensor();
        setMemTitle(mem.getAlertName());
        setMemValue(mem.readValue());
        setMemReport(mem.getReport());
    }

    public JPanel getMemoryPanel() {
        JPanel memoryUsagePnl = new JPanel();
        memoryUsagePnl.setBorder(new TitledBorder(memTitle));

        // Uses a FlowLayout to place the box in the top left corner of the provided grid
        JPanel subPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));

        JPanel pane = new JPanel();
        BoxLayout boxlayout = new BoxLayout(pane, BoxLayout.Y_AXIS);
        pane.setLayout(boxlayout);

        // set size of box
        double value = memValue;
        if (value < 10) {
            pane.setPreferredSize(new Dimension(75, 50));
        } else if (value >= 10 && value < 15) {
            pane.setPreferredSize(new Dimension(100, 50));
        } else if (value >= 15) {
            pane.setPreferredSize(new Dimension(150, 50));
        }
        // set color of box
        if (value >= 10 && value <= 13) {
            pane.setBackground(Color.yellow);
        } else if (value < 10) {
            pane.setBackground(Color.green);
        } else if (value > 13) {
            pane.setBackground(Color.red);
        }
        subPanel.add(pane);

        BorderLayout layout = new BorderLayout();
        memoryUsagePnl.setLayout(layout);
        memoryUsagePnl.add(subPanel, BorderLayout.NORTH);

        // On the line below the box we will create a series of spaces to place
        // the Report message in the correct placement.
        JPanel textBox = new JPanel();
        String report = memReport;
        JLabel label = new JLabel(spacing() + report + " ---> " + value);
        textBox.add(label);
        memoryUsagePnl.add(textBox, BorderLayout.WEST);

        return memoryUsagePnl;
    }

    private String spacing() {
        return " ".repeat(Math.max(0, 30));
    }

    @Override
    public String getAlertName() {
        return memTitle;
    }

    @Override
    public double readValue() {
        return memValue;
    }

    @Override
    public String getReport() {
        return memReport;
    }

    private void setMemTitle(String title) {
        memTitle = title;
    }

    private void setMemValue(double value) {
        memValue = value;
    }

    private void setMemReport(String report) {
        memReport = report;
    }
}
