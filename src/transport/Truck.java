package transport;

public class Truck extends Transport {


    public Truck(String brand, String model, float engineVolume) {
        super(brand, model, engineVolume);
    }

    public Truck(String brand, String model) {
        super(brand, model, 8.0f);
    }

    @Override
    void startMove() {

    }

    @Override
    void stopMove() {

    }

    @Override
    public String toString() {
        return "Грузовик: " + super.toString();
    }
}
