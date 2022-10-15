package transport;

//для транспорта, который должен был пройти диагностику и не прошел

public class NotDiagnostedException extends Exception  {
    private Transport transport;

    public NotDiagnostedException(String message, Transport transport) {
        super(message);
        if (!transport.getClass().equals(Bus.class)) {
            this.transport = transport;
        }
    }

    public Transport getTransport() {
        return transport;
    }
}
