package transport;

public class Car extends Transport {

    public Car(String brand, String model, float engineVolume) {
        super(brand, model, engineVolume);
    }

    public Car(String brand, String model) {
        super(brand, model);
    }


    @Override
    void startMove() {

    }

    @Override
    void stopMove() {

    }

    @Override
    public String toString() {
        return "Легковой автомобиль: " + super.toString();
    }
}
