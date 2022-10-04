package transport;

import java.security.SecureRandom;

public class Bus extends Transport implements Competing {
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

    @Override
    public String pitStop() {
        return "стоит на пит-стопе 70 секунд (18 колес все-таки)";
    }

    @Override
    public float bestLapTime() {
        return 37.5f;
    }

    @Override
    public float maxSpeed() {
        return 225.67f;
    }
}
