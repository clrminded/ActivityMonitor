import javax.swing.*;

/**
 * Christopher Liudahl-Rackley
 * CS401 - Activity Monitor
 * This is an Activity Monitoring app that simulates the running cpu utilization
 * rate, memory usage, and disk usage and provides a rating that tells the user
 * the condition that their computer is running. This program is using an
 * adaptor design program that uses classes that are sharing an interface that is
 * that is working with another library indirectly in order to have access to the
 * library directly to prevent any modification to the library itself.
 * The Activity Monitor GUI class is an instance of the ActivityMonitor class. The
 * ActivityMonitor class initiates instances of a CpuAdaptor, MemoryAdaptor, and DeskAdaptor
 * class, each implementing their versions of the Sensor interface. Each of the Adaptor
 * classes are the ones that initiates the instances of the library sensor classes, leaving
 * the client having no direct way to call or modify the library class directly.
 */

public class ActivityMonitorGUI extends JFrame {
    public static void main(String[] args) {
        ActivityMonitor app = new ActivityMonitor();
        System.out.println(app.getCpuTitle() + ": " + app.getCpuValue() + " ---> " + app.getCpuReport());
        System.out.println(app.getMemoryTitle() + ": " + app.getMemoryValue() + " ---> " + app.getMemoryReport());
        System.out.println(app.getDeskTitle() + ": " + app.getDeskValue() + " ---> " + app.getDeskReport());
    }
}
