import libs.DeskUsageSensor;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Christopher Liudahl-Rackley
 * 5/28/2022
 * CS410-Software Engineering
 * <p>
 * This is the DeskAdaptor class that implements all of the methods of the
 * Sensor interface. It does this by setting the value of the getter methods
 * from the DeskUsageSensor library to the values of the instances of the
 * Adaptor class. By using this Adaptor Design Pattern we can hide the implementation
 * of the methods in the library, preventing any changes of the library to occur.
 * Then we can instantiate this Adaptor class in the client, and use all of the
 * libraries methods.
 */

class DeskAdaptor implements Sensor {
    private String deskTitle;
    private double deskValue;
    private String deskReport;

    /**
     * DeskAdaptor Constructor with no params
     * Allocated memory from the DeskUsageSensor library and sets
     * all of the class variables to the values of the getter methods
     * from the library.
     */
    public DeskAdaptor() {
        DeskUsageSensor desk = new DeskUsageSensor();
        setDeskTitle(desk.getAlertName());
        setDeskValue(desk.readValue());
        setDeskReport(desk.getReport());
    }

    public JPanel getDeskPanel() {
        JPanel deskUsagePnl = new JPanel();
        deskUsagePnl.setBorder(new TitledBorder(getAlertName()));

        // Uses a FlowLayout to place the box in the top left corner of the provided grid
        JPanel subPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));

        JPanel pane = new JPanel();
        BoxLayout boxlayout = new BoxLayout(pane, BoxLayout.Y_AXIS);
        pane.setLayout(boxlayout);

        // set box size
        double value = readValue();

        if (value < 10) {
            pane.setPreferredSize(new Dimension(75, 50));
        } else if (value >= 10 && value < 15) {
            pane.setPreferredSize(new Dimension(100, 50));
        } else if (value >= 15) {
            pane.setPreferredSize(new Dimension(150, 50));
        }
        // set box color
        if (value >= 700 && value <= 900) {
            pane.setBackground(Color.yellow);
        } else if (value < 700) {
            pane.setBackground(Color.green);
        } else if (value > 900) {
            pane.setBackground(Color.red);
        }

        subPanel.add(pane);

        BorderLayout layout = new BorderLayout();
        deskUsagePnl.setLayout(layout);
        deskUsagePnl.add(subPanel, BorderLayout.NORTH);

        // On the line below the box we will create a series of spaces to place
        // the Report message in the correct placement.
        JPanel textBox = new JPanel();
        String report = getReport();
        JLabel label = new JLabel(spacing() + report + " ---> " + value);
        textBox.add(label);
        deskUsagePnl.add(textBox, BorderLayout.WEST);

        return deskUsagePnl;
    }

    private String spacing() {
        return " ".repeat(Math.max(0, 30));
    }

    @Override
    public String getAlertName() {
        return deskTitle;
    }

    @Override
    public double readValue() {
        return deskValue;
    }

    @Override
    public String getReport() {
        return deskReport;
    }

    private void setDeskTitle(String title) {
        deskTitle = title;
    }

    private void setDeskValue(double value) {
        deskValue = value;
    }

    private void setDeskReport(String report) {
        deskReport = report;
    }
}
