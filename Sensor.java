public interface Sensor {
    String getAlertName();

    double readValue();

    String getReport();
}
