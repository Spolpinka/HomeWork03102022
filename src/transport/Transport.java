package transport;

public abstract class Transport {
    private String brand = "default";
    private String model = "default";
    private float engineVolume = 1.6f;

    public Transport(String brand, String model, float engineVolume) {
        if (brand != null && !brand.isBlank() && !brand.isEmpty()) {
            this.brand = brand;
        }
        if (model != null && !model.isEmpty() && !model.isBlank()) {
            this.model = model;
        }
        if (engineVolume > 0) {
            this.engineVolume = engineVolume;
        }
    }

    public Transport(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public abstract void startMove();

    public abstract void stopMove();

    abstract void getAutoType();

    abstract void setDiagnostic() throws NotDiagnosableException;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public float getEngineVolume() {
        return engineVolume;
    }

    @Override
    public String toString() {
        return "марка - " + brand +
                ", модель - " + model +
                ", объем двигателя - " + engineVolume;
    }
}
