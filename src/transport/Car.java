package transport;

public class Car extends Transport implements Competing {

    private CarBodyType bodyType;
    protected boolean isDiagnosted = false;


    @Override
    public void setDiagnostic() {
        isDiagnosted = true;
    }
    public boolean getDiagnostic() {
        return isDiagnosted;
    }

    public Car(String brand, String model, float engineVolume, CarBodyType bodyType) {
        super(brand, model, engineVolume);
        this.bodyType = bodyType;
    }

    public Car(String brand, String model, float engineVolume) {
        super(brand, model, engineVolume);
    }

    public Car(String brand, String model) {
        super(brand, model);
    }
    public CarBodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(CarBodyType bodyType) {
        if (bodyType != null) {
            this.bodyType = bodyType;
        }
    }


    @Override
    public void startMove() {
        System.out.println("Автомобиль " + getBrand() + getModel() +" начал движение");
    }

    @Override
    public void stopMove() {
        System.out.println("Автомобиль " + getBrand() + getModel() + " остановился");
    }

    @Override
    void getAutoType() {
        if (getBodyType() != null) {
            System.out.println(getBodyType().name());
        } else {
            System.out.println("Данных недостаточно");
        }
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
