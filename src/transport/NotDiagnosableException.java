package transport;

//если вдруг кто то захочет отдиагностировать Bus

public class NotDiagnosableException extends Exception {
    private Bus bus;

    public NotDiagnosableException (String message, Bus bus) {
        super(message);
        this.bus = bus;
    }

    public Bus getBus() {
        return bus;
    }
}
