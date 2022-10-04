package transport;

public class Truck extends Transport implements Competing {


    public Truck(String brand, String model, float engineVolume) {
        super(brand, model, engineVolume);
    }

    public Truck(String brand, String model) {
        super(brand, model, 8.0f);
    }

    @Override
    void startMove() {
        System.out.println("Грузовик начал движение");
    }

    @Override
    void stopMove() {
        System.out.println("Грузовик остановился");
    }

    @Override
    public String toString() {
        return "Грузовик: " + super.toString();
    }

    @Override
    public String pitStop() {
        return "стоит на пит-стопе 25 секунд";
    }

    @Override
    public float bestLapTime() {
        return 25.5f;
    }

    @Override
    public float maxSpeed() {
        return 230.85f;
    }
}
