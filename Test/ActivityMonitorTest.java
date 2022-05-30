import libs.CpuUtilizationSensor;
import libs.DeskUsageSensor;
import libs.MemoryUsageSensor;
import org.junit.jupiter.api.Test;

public class ActivityMonitorTest {
    @Test
    void getCpuTitleTest() {
        ActivityMonitor active = new ActivityMonitor();
        CpuAdaptor cpu = new CpuAdaptor();
        CpuUtilizationSensor sensor = new CpuUtilizationSensor();
        assert (active.getCpuTitle().equals(cpu.getAlertName()));
        assert (cpu.getAlertName().equals(sensor.getAlertName()));
        assert (active.getCpuTitle().equals(sensor.getAlertName()));
    }

    @Test
    void getDeskTitleTest() {
        ActivityMonitor active = new ActivityMonitor();
        DeskAdaptor desk = new DeskAdaptor();
        DeskUsageSensor usage = new DeskUsageSensor();
        assert (active.getDeskTitle().equals(desk.getAlertName()));
        assert (desk.getAlertName().equals(usage.getAlertName()));
        assert (active.getDeskTitle().equals(usage.getAlertName()));
    }

    @Test
    void getMemoryTitleTest() {
        ActivityMonitor active = new ActivityMonitor();
        MemoryAdaptor mem = new MemoryAdaptor();
        MemoryUsageSensor usage = new MemoryUsageSensor();
        assert (active.getMemoryTitle().equals(mem.getAlertName()));
        assert (mem.getAlertName().equals(usage.getAlertName()));
        assert (active.getMemoryTitle().equals(usage.getAlertName()));
    }

}
