package people;

import main.Main;
import transport.Transport;

import java.util.List;

public class Mechanic {
    private String firstName;
    private String lastName;
    private String company;
    private List<LicenseCategory> transportClasses;

    public Mechanic(String firstName, String lastName, String company, List<LicenseCategory> transportTypes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.transportClasses = transportTypes;
        if (Main.getMechanics().contains(this)) {
            for (Mechanic m :
                    Main.getMechanics()) {
                System.out.println(m);
            }
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public List<LicenseCategory> getTransportClasses() {
        return transportClasses;
    }

    public void service(Transport transport) {
        System.out.println("техобслуживание " + transport.getBrand() + transport.getModel() + " проведено!");;
    }

    public void fixTransport(Transport transport) {
        System.out.println("ремонт транспорта " + transport.getBrand() + transport.getModel() + " проведен!");
    }
}
