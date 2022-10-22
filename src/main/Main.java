package main;

import people.*;
import transport.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main<T extends Transport> {
    private static Transport[] transports;//гараж общий
    private static Set<Transport> transportList; // он же списком
    private static Set<Driver> drivers; // комната водителей
    private static Set<Mechanic> mechanics; // гараж механиков
    private static Set<Sponsor> sponsors; // бильярдный клуб спонсоров

    public static void main(String[] args) {
        task1();
    }

    {

    }

    static void task1() {
        //создаем произвольные car
        Transport lada = new Car("Лада", "Веста Sport");
        Car ferrari = new Car("Ferrari", "296 GTS", 6.0f);
        Car bugatti = new Car("Bugatti", "Veron", 8.0f, CarBodyType.SEDAN);
        Car uas = new Car("УАЗ", "UAZ-3909");

        //произвольные truck
        Transport volvo = new Truck("Volvo", "FH16", 10.0f);
        Truck scania = new Truck("Scania", "R 410 6 × 2 Highline", 12.0f);
        Truck kamaz = new Truck("КамАЗ", "43118", 12.2f);
        Truck ural = new Truck("Урал", "Урал-375");

        //произвольные bus
        Transport hyundai = new Bus("Hyudai", "County");
        Bus neoplan = new Bus("Neoplan", "Tourliner", 13.6f);
        Bus bogdan = new Bus("БОГДАН", "А201");
        Bus liaz = new Bus("ЛИАЗ", "5250 Вояж");

        transports = new Transport[]{
                lada
                , ferrari
                , bugatti
                , uas
                , volvo
                , scania
                , kamaz
                , ural
                , hyundai
                , neoplan
                , bogdan
                , liaz
        };

        transportList = new HashSet<>();
        //заполняем список транспорта
        transportList.addAll(Arrays.asList(transports));
        addTransport(lada);//проверка метода

        //создаем 4 водителей
        createDrivers(bugatti, kamaz, ferrari, neoplan);

        //создаем 4 спонсоров
        createSponsors();

        //создаем механиков
        createMechanics();

        //пробуем добавить водителя в другой авто
        neoplan.setDriver((Driver) drivers.toArray()[3]);
/*
        for (Transport t :
                transportList) {

            for (Sponsor s :
                    sponsors) {
                t.setSponsors(s);
            }
            for (Mechanic m :
                    mechanics) {
                t.setMechanics(m);
            }
        }

/*

        printCompetition(sanka);
        printCompetition(fedya);
        printCompetition(serega);
        printCompetition(misha);
        printCompetition(vanya);


        bugatti.setDiagnostic();
        scania.setDiagnostic();
        ferrari.setDiagnostic();
        ural.setDiagnostic();

        for (Transport transport : transports) {
            try {
                checkDiagnostic(transport);
            } catch (NotDiagnostedException e) {
                System.out.println(e.getMessage());
            }
        }

        sanka.getTransport().startMove();
        sanka.getTransport().stopMove();
        fedya.getTransport().startMove();
        fedya.getTransport().stopMove();

        ((Truck) volvo).setLoadCapacity(TruckLoadCapacity.N3);
        scania.setLoadCapacity(TruckLoadCapacity.N3);
        ural.setLoadCapacity(TruckLoadCapacity.N3);
        System.out.println(ural.getLoadCapacity());
        */


        //выводим машины с заданным ДЗ1 от 12.10.2022 описанием
        //printTransportInfo();

    }

    private static void printTransport(Competing... transports) {
        for (Competing transport : transports) {
            System.out.println(transport);
            System.out.println("время пит-стопа - " + transport.pitStop());
            System.out.println("лучшая скорость - " + transport.maxSpeed() + " км/ч");
            System.out.println("лучшее время круга - " + transport.bestLapTime() + " секунд");
        }
    }

    private static void printCompetition(Driver driver) {
        if (driver.getTransport() != null) {
            System.out.println(driver + " и будет участвовать в заезде!");
        } else {
            System.out.println(driver);
        }
    }

    private static void checkDiagnostic(Transport transport) throws NotDiagnostedException {
        if (!transport.getClass().equals(Bus.class)) {
            if (transport.getClass().equals(Car.class)) {
                Car car = (Car) transport;
                if (car.getDiagnostic()) {
                    System.out.println("Легковой автомобиль " + car.getBrand() + car.getModel() + " диагностирован");
                } else {
                    throw new NotDiagnostedException("Не диагностирована легковая машина " +
                            car.getModel() + car.getBrand(), car);
                }
            } else {
                Truck truck = (Truck) transport;
                if (truck.getDiagnostic()) {
                    System.out.println("Грузовик " + truck.getBrand() + truck.getModel() + " диагностирован");
                } else {
                    throw new NotDiagnostedException("Не диагностирован грузовик " +
                            truck.getBrand() + truck.getModel(), truck);
                }
            }
        } else {
            System.out.println("Автобус " + transport.getBrand() + transport.getModel() + " в диагностике не нуждается");
        }
    }

    private static void createDrivers(Car bugatti, Truck kamaz, Car ferrari, Bus neoplan) {
        drivers = new HashSet<>();
        Driver sanka = new Driver<>("Санька", LicenseCategory.B, 10);
        try {
            sanka.addTransport(bugatti);
        } catch (NoLicenseException e) {
            System.out.println(e.getMessage());
        }

        Driver fedya = new Driver("Федя", LicenseCategory.C, 12);
        try {
            fedya.addTransport(kamaz);
        } catch (NoLicenseException e) {
            System.out.println(e.getMessage());
        }


        Driver serega = new Driver("Серёга", LicenseCategory.D, 20);
        try {
            serega.addTransport(ferrari);
        } catch (NoLicenseException e) {
            System.out.println(e.getMessage());
        }

        Driver<Car> misha = new Driver<>("Михаэль Шумахер", LicenseCategory.B, 30);
        try {
            misha.addTransport((Car) ferrari);
        } catch (NoLicenseException e) {
            System.out.println(e.getMessage());
        }

        Driver<Bus> vanya = new Driver<>("Иван", LicenseCategory.D, 15);
        try {
            vanya.addTransport(neoplan);//да, тут ничего кроме Bus не даст вводить IDEA
        } catch (NoLicenseException e) {
            System.out.println(e.getMessage());
        }
        addDriver(sanka);
        addDriver(fedya);
        addDriver(serega);
        addDriver(misha);
        addDriver(vanya);
        addDriver(vanya); //пробуем дублировать Ваньку
    }

    private static void createSponsors() {
        sponsors = new HashSet<>();
        Sponsor fedya = new Sponsor("Федор Емельяненко", 10000000);
        addSponsor(fedya);
        Sponsor aleksandr = new Sponsor("Александр Цыкало", 15000000);
        addSponsor(aleksandr);
        Sponsor katya = new Sponsor("Екатерина Варнава", 7000000);
        addSponsor(katya);
        Sponsor misha = new Sponsor("Михаил Жванецкий", 8500000);
        addSponsor(misha);
        addSponsor(misha);//пробуем дублировать Мишаню
    }

    private static void createMechanics() {
        mechanics = new HashSet<>();
        ArrayList<LicenseCategory> licensesB = new ArrayList<>();
        licensesB.add(LicenseCategory.B);
        ArrayList<LicenseCategory> licensesBC = new ArrayList<>();
        licensesBC.add(LicenseCategory.B);
        licensesBC.add(LicenseCategory.C);
        ArrayList<LicenseCategory> licensesBCD = new ArrayList<>();
        licensesBCD.add(LicenseCategory.B);
        licensesBCD.add(LicenseCategory.C);
        licensesBCD.add(LicenseCategory.D);

        Mechanic feodosii = new Mechanic("Феодосий", "Петропавловский",
                "Двулесье", licensesB);
        Mechanic mikola = new Mechanic("Микола", "Мастрояни",
                "Железные поршни", licensesBC);
        Mechanic dilerma = new Mechanic("Дилерма", "Бакиева",
                "Горячие источники", licensesBCD);
        Mechanic ivanich = new Mechanic("Иваныч", "Шлебенштайн",
                "1000 мелочей", licensesBCD);

        addMechanic(feodosii);
        addMechanic(mikola);
        addMechanic(dilerma);
        addMechanic(ivanich);
        addMechanic(ivanich);//пробуем дублировать Иваныча
    }

    private static void printTransportInfo() {
        for (Transport t :
                transportList) {
            System.out.println("транспорт -" + t + ":\n" +
                    "Водителя зовут: " + (t.getDriver() == null ? "нет водителя" : t.getDriver().getName()) + ";\n" +
                    "Спонсоры: " + t.getSponsorsNames() + "\n" +
                    "Механики: " + t.getMechanicsNames());
        }
    }

    private static void addTransport(Transport transport) {
        if (!transportList.contains(transport)) {
            transportList.add(transport);
        } else {
            printTransportInfo();
        }
    }

    private static void addSponsor(Sponsor sponsor) {
        if (!sponsors.contains(sponsor)) {
            sponsors.add(sponsor);
        } else {
            for (Sponsor s : sponsors) {
                System.out.println(s);
            }
        }
    }

    private static void addMechanic(Mechanic mechanic) {
        if (!mechanics.contains(mechanic)) {
            mechanics.add(mechanic);
        } else {
            for (Mechanic m :
                    mechanics) {
                System.out.println(m);
            }
        }
    }

    private static void addDriver(Driver driver) {
        if (!drivers.contains(driver)) {
            drivers.add(driver);
        } else {
            for (Driver d :
                    drivers) {
                System.out.println(d);
            }
        }
    }

    public static Transport[] getTransports() {
        return transports;
    }

    public static Set<Transport> getTransportList() {
        return transportList;
    }

    public static Set<Driver> getDrivers() {
        return drivers;
    }

    public static Set<Mechanic> getMechanics() {
        return mechanics;
    }

    public static Set<Sponsor> getSponsors() {
        return sponsors;
    }
}