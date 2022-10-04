package transport;

public class Car extends Transport implements Competing {

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

    @Override
    public String pitStop() {
        return "стоит на пит-стопе 15 секунд";
    }

    @Override
    public float bestLapTime() {
        return 15.0f;
    }

    @Override
    public float maxSpeed() {
        return 299.0f;
    }
}
