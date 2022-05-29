import javax.swing.*;
import java.awt.*;

public class ActivityMonitor extends JFrame {
    private CpuAdaptor cpu;
    private MemoryAdaptor mem;
    private DeskAdaptor desk;

    public ActivityMonitor() {
        setTitleAndLayout();
        init();
        add(cpu.getCpuPanel());
        add(mem.getMemoryPanel());
        add(desk.getDeskPanel());
        setFrame();
    }

    private void setTitleAndLayout() {
        setTitle("Activity Monitor Tracker");
        setLayout(new GridLayout(3, 1));
    }

    private void setFrame() {
        setPreferredSize(new Dimension(600, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    public void init() {
        cpu = new CpuAdaptor();
        mem = new MemoryAdaptor();
        desk = new DeskAdaptor();
    }

    public String getCpuTitle() {
        return cpu.getAlertName();
    }

    public String getMemoryTitle() {
        return mem.getAlertName();
    }

    public String getDeskTitle() {
        return desk.getAlertName();
    }

    public double getCpuValue() {
        return cpu.readValue();
    }

    public double getMemoryValue() {
        return mem.readValue();
    }

    public double getDeskValue() {
        return desk.readValue();
    }

    public String getCpuReport() {
        return cpu.getReport();
    }

    public String getMemoryReport() {
        return mem.getReport();
    }

    public String getDeskReport() {
        return desk.getReport();
    }
}



