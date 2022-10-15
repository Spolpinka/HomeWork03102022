package transport;

public class Truck extends Transport implements Competing {

    private TruckLoadCapacity loadCapacity;
    private boolean isDiagnosted = false;


    public Truck(String brand, String model, float engineVolume) {
        super(brand, model, engineVolume);
    }

    public Truck(String brand, String model) {
        super(brand, model, 8.0f);
    }

    public TruckLoadCapacity getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(TruckLoadCapacity loadCapacity) {
        if (loadCapacity != null) {
            this.loadCapacity = loadCapacity;
        }
    }

    @Override
    public void startMove() {
        System.out.println("Грузовик " +  getBrand() + " " + getModel() + " начал движение");
    }

    @Override
    public void stopMove() {
        System.out.println("Грузовик "  + getBrand() + " " + getModel() + " остановился");
    }

    @Override
    void getAutoType() {
        if (getLoadCapacity() != null) {
            System.out.println(getLoadCapacity().name());
        } else {
            System.out.println("Данных недостаточно");
        }
    }

    @Override
    public void setDiagnostic() {
        isDiagnosted = true;
    }
    public boolean getDiagnostic() {
        return isDiagnosted;
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
