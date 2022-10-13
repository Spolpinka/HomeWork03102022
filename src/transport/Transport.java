package transport;

import people.Driver;
import people.Mechanic;
import people.Sponsor;
import java.util.List;

public abstract class Transport {
    private String brand = "default";
    private String model = "default";
    private float engineVolume = 1.6f;
    private List<Sponsor> sponsors; // спонсоры

    private List<Mechanic> mechanics; // механики
    private Driver driver; // водитель

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

    public List<Sponsor> getSponsors() {
        return sponsors;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setSponsors(Sponsor... sponsors) {
        for (Sponsor s :
                sponsors) {
            this.sponsors.add(s);
        }
    }

    public void setDriver(Driver driver) {
        if (driver.getTransport() == null) {
            this.driver = driver;
        } else {
            System.out.println("Водитель " + driver.getName() + " уже закреплен за автомобилем!");
        }
    }

    @Override
    public String toString() {
        return "марка - " + brand +
                ", модель - " + model +
                ", объем двигателя - " + engineVolume;
    }
}
