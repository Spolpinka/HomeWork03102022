package people;

import transport.Car;

import java.util.List;

public class Mechaniс {
    private String firstName;
    private String lastName;
    private String company;
    private List<Object> transportClasses;

    public Mechaniс(String firstName, String lastName, String company, List<Object> transportTypes) {
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
}
