import libs.MemoryUsageSensor;
import org.junit.jupiter.api.Test;

public class MemoryAdaptorTest {
    @Test
    void getAlertNameTest() {
        MemoryAdaptor mem = new MemoryAdaptor();
        MemoryUsageSensor memUsage = new MemoryUsageSensor();
        assert (mem.getAlertName().equals(memUsage.getAlertName()));
    }

    @Test
    void getReportTest() {
        MemoryAdaptor mem = new MemoryAdaptor();
        MemoryUsageSensor memUsage = new MemoryUsageSensor();
        assert (mem.getReport().equals(memUsage.getReport()));
    }

    
}
