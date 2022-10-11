public class NoLicenseException extends Exception {
    private Driver driver;

    public NoLicenseException(String message, Driver driver) {
        super(message);
        this.driver = driver;
    }

    public Driver getDriver() {
        return driver;
    }
}
