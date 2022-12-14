package people;

import transport.Bus;
import transport.Car;
import transport.Transport;
import transport.Truck;

public class Driver <T extends Transport> {
    private String name;
    private LicenseCategory license;
    private int experience; // в годах

    public String getName() {
        return name;
    }

    public LicenseCategory getLicense() {
        return license;
    }

    public int getExperience() {
        return experience;
    }

    private Transport transport;

    public Transport getTransport() {
        return transport;
    }

    public Driver(String name, LicenseCategory license, int experience) {
        if (name != null && !name.isEmpty() && !name.isBlank()) {
            this.name = name;
        }
        if (license != null) {
            this.license = license;
        }
        if (experience > 0) {
            this.experience = experience;
        }

    }

    public void addTransport(T transport) throws NoLicenseException {
        if (this.transport == null) {
            if (transport.getClass().equals(Car.class) && license.equals(LicenseCategory.B)) {
                this.transport = transport;
            } else if (transport.getClass().equals(Truck.class) && license.equals(LicenseCategory.C)) {
                this.transport = transport;
            } else if (transport.getClass().equals(Bus.class) && license.equals(LicenseCategory.D)) {
                this.transport = transport;
            } else {
                throw new NoLicenseException("Необходимо указать тип прав для водителя " + this.getName(), this);
            }
        } else {
            System.out.println("За данным водителем уже закреплен автомобиль " +
                    transport.getBrand() + transport.getModel());
        }
    }

    @Override
    public String toString() {
        String s;
        if (this.transport != null) {
            s = " управляет следующим транспортом - " + transport;
        } else {
            s = " остался без машины!";
        }

        return "Водитель - " + name + s;
    }
}
