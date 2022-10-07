import transport.*;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {task1();}{

    }

    static void task1(){
        //создаем произвольные car
        Transport lada = new Car("Лада", "Веста Sport");
        Transport ferrari = new Car("Ferrari", "296 GTS", 6.0f);
        Transport bugatti = new Car("Bugatti", "Veron", 8.0f, CarBodyType.SEDAN);
        Transport uas = new Car("УАЗ", "UAZ-3909");

        //произвольные truck
        Transport volvo = new Truck("Volvo", "FH16", 10.0f);
        Truck scania = new Truck("Scania", "R 410 6 × 2 Highline", 12.0f);
        Truck kamaz = new Truck("КамАЗ", "43118", 12.2f);
        Truck ural = new Truck("Урал", "Урал-375");

        //произвольные bus
        Transport hyundai = new Bus("Hyudai", "County");
        Bus neoplan = new Bus("Neoplan", "Tourliner", 13.6f);
        Transport bogdan = new Bus("БОГДАН", "А201");
        Transport liaz = new Bus("ЛИАЗ", "5250 Вояж");

        Transport[] transports = {
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

        printTransport((Competing) bugatti, (Competing) scania, (Competing) bogdan);

        Driver sanka = new Driver<>("Санька", LicenseCategory.B, 10);
        sanka.addTransport(bugatti);

        Driver fedya = new Driver("Федя", LicenseCategory.C, 12);
        fedya.addTransport(kamaz);
        Driver serega = new Driver("Серёга", LicenseCategory.D, 20);
        serega.addTransport(ferrari);
        Driver<Car> misha = new Driver<>("Михаэль Шумахер", LicenseCategory.B, 30);
        misha.addTransport((Car) ferrari);
        Driver<Bus> vanya = new Driver<>("Иван", LicenseCategory.D, 15);
        vanya.addTransport(neoplan);//да, тут ничего кроме Bus не даст вводить IDEA

        printCompetition(sanka);
        printCompetition(fedya);
        printCompetition(serega);
        printCompetition(misha);
        printCompetition(vanya);

        for (Transport transport: transports) {
            System.out.println(transport);
        }

        sanka.getTransport().startMove();
        sanka.getTransport().stopMove();
        fedya.getTransport().startMove();
        fedya.getTransport().stopMove();

        ((Truck) volvo).setLoadCapacity(TruckLoadCapacity.N3);
        scania.setLoadCapacity(TruckLoadCapacity.N3);
        ural.setLoadCapacity(TruckLoadCapacity.N3);
        System.out.println(ural.getLoadCapacity());
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
}