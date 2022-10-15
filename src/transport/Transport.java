package transport;

import people.Driver;
import people.Mechanic;
import people.Sponsor;

import java.util.ArrayList;
import java.util.List;

public abstract class Transport {
    private String brand = "default";
    private String model = "default";
    private float engineVolume = 1.6f;
    private List<Sponsor> sponsors = new ArrayList<>(); // спонсоры
    private List<Mechanic> mechanics = new ArrayList<>(); // механики
    private Driver driver; // водитель
    private final int MAX_MECHANICS = 3; // максимальное количество механиков



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

    public List<Mechanic> getMechanics() {
        return mechanics;
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

    public void setMechanics(Mechanic... mechanics) {
        for (Mechanic m :
                mechanics) {
            if (this.mechanics.size() < MAX_MECHANICS && m.getTransportClasses().contains(this.getClass())) {
                this.mechanics.add(m);
            } else if (this.mechanics.size() >= MAX_MECHANICS){
                System.out.println("У транспорта " + this.getBrand() + this.getModel() +
                        " максимальное количество механиков - 6 рук");
            } else {
                System.out.println("Квалификация механика не соответствует классу машины!");
            }
        }
    }

    @Override
    public String toString() {
        return "марка - " + brand +
                ", модель - " + model +
                ", объем двигателя - " + engineVolume;
    }

    public String getSponsorsNames() {
        String result = "";
        for (int i = 0; i < this.getSponsors().size(); i++) {
            result += this.getSponsors().get(i).getName() + ", ";
        }
        return result;
    }
    public String getMechanicsNames() {
        String result = "";
        for (int i = 0; i < this.getMechanics().size(); i++) {
            result += this.getMechanics().get(i).getFirstName() + " " +
                    this.getMechanics().get(i).getLastName() + ", ";
        }
        return result;
    }


}
