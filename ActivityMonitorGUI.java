import javax.swing.*;
import java.security.NoSuchAlgorithmException;

public class ActivityMonitorGUI extends JFrame {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        ActivityMonitor app = new ActivityMonitor();
        System.out.println(app.getCpuTitle() + ": " + app.getCpuValue() + " ---> " + app.getCpuReport());
        System.out.println(app.getMemoryTitle() + ": " + app.getMemoryValue() + " ---> " + app.getMemoryReport());
        System.out.println(app.getDeskTitle() + ": " + app.getDeskValue() + " ---> " + app.getDeskReport());
    }
}
