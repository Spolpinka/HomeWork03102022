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
        System.out.println("Автобус начал движение");
    }

    @Override
    void stopMove() {
        System.out.println("Автобус остановился");
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
