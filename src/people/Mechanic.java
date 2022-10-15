package people;

import transport.Transport;

import java.util.List;

public class Mechanic {
    private String firstName;
    private String lastName;
    private String company;
    private List<Object> transportClasses;

    public Mechanic(String firstName, String lastName, String company, List<Object> transportTypes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.transportClasses = transportTypes;
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

    public List<Object> getTransportClasses() {
        return transportClasses;
    }

    public void service(Transport transport) {
        System.out.println("техобслуживание " + transport.getBrand() + transport.getModel() + " проведено!");;
    }

    public void fixTransport(Transport transport) {
        System.out.println("ремонт транспорта " + transport.getBrand() + transport.getModel() + " проведен!");
    }
}
