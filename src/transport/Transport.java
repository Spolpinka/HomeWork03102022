package transport;

public abstract class Transport {
    private String brand = "default";
    private String model = "default";
    private float engineVolume = 1.5f;

    abstract void startMove();

    abstract void stopMove();

}
