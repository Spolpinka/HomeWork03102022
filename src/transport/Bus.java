package transport;

public class Bus extends Transport {
    public Bus(String brand, String model, float engineVolume) {
        super(brand, model, engineVolume);
    }

    public Bus(String brand, String model) {
        super(brand, model, 12.0f);
    }

    @Override
    void startMove() {

    }

    @Override
    void stopMove() {

    }

    @Override
    public String toString() {
        return "Автобус: " + super.toString();
    }
}
