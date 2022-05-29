import libs.CpuUtilizationSensor;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Christopher Liudahl-Rackley
 * 5/28/2022
 * CS410-Software Engineering
 * <p>
 * This is the CpuAdaptor class that implements all of the methods of the
 * Sensor interface. It does this by setting the value of the getter methods
 * from the CpuUtilizationSensor library to the values of the instances of the
 * Adaptor class. By using this Adaptor Design Pattern we can hide the implementation
 * of the methods in the library, preventing any changes of the library to occur.
 * Then we can instantiate this Adaptor class in the client, and use all of the
 * libraries methods.
 */

class CpuAdaptor implements Sensor {
    private String cpuTitle;
    private String cpuReport;
    private double cpuValue;

    /**
     * CpuAdaptor Constructor with no params
     * Allocated memory from the CpuUtilizationSensor library and sets
     * all of the class variables to the values of the getter methods
     * from the library.
     */
    public CpuAdaptor() {
        CpuUtilizationSensor cpu = new CpuUtilizationSensor();
        setCpuTitle(cpu.getAlertName());
        setCpuValue((int) (Math.random() * 100));
        setCpuReport(cpu.getReport());
    }

    public JPanel getCpuPanel() {
        JPanel cpuUsagePnl = new JPanel();
        cpuUsagePnl.setBorder(new TitledBorder(getAlertName()));

        // Uses a FlowLayout to place the box in the top left corner of the provided grid
        JPanel subPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));

        JPanel pane = new JPanel();
        BoxLayout boxlayout = new BoxLayout(pane, BoxLayout.Y_AXIS);
        pane.setLayout(boxlayout);
        double value = readValue();
        if (value < 10) {
            pane.setPreferredSize(new Dimension(75, 50));
        } else if (value >= 10 && value < 15) {
            pane.setPreferredSize(new Dimension(100, 50));
        } else if (value >= 15) {
            pane.setPreferredSize(new Dimension(150, 50));
        }

        if (value >= 75 && value <= 90) {
            pane.setBackground(Color.yellow);
        } else if (value < 75) {
            pane.setBackground(Color.green);
        } else if (value > 90) {
            pane.setBackground(Color.red);
        }
        subPanel.add(pane);

        BorderLayout layout = new BorderLayout();
        cpuUsagePnl.setLayout(layout);
        cpuUsagePnl.add(subPanel, BorderLayout.NORTH);

        // On the line below the box we will create a series of spaces to place
        // the Report message in the correct placement.
        JPanel textBox = new JPanel();
        String report = getReport();
        JLabel label = new JLabel(spacing() + report + " ---> " + value);
        textBox.add(label);
        cpuUsagePnl.add(textBox, BorderLayout.WEST);

        return cpuUsagePnl;
    }

    private String spacing() {
        return " ".repeat(Math.max(0, 30));
    }

    @Override
    public String getAlertName() {
        return cpuTitle;
    }

    @Override
    public double readValue() {
        return cpuValue;
    }

    @Override
    public String getReport() {
        if (cpuValue >= 75 && cpuValue <= 90) {
            cpuReport = "CRITICAL";
        } else if (cpuValue < 75) {
            cpuReport = "OK";
        } else {
            cpuReport = "DANGER";
        }
        return cpuReport;
    }

    private void setCpuTitle(String title) {
        cpuTitle = title;
    }

    private void setCpuValue(double value) {
        cpuValue = value;
    }

    private void setCpuReport(String report) {
        cpuReport = report;
    }
}



