import org.w3c.dom.ls.LSOutput;
import transport.*;

public class Main<T extends Transport> {
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

        printTransport(bugatti, scania, bogdan, liaz);

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

        /*sanka.getTransport().startMove();
        sanka.getTransport().stopMove();
        fedya.getTransport().startMove();
        fedya.getTransport().stopMove();

        ((Truck) volvo).setLoadCapacity(TruckLoadCapacity.N3);
        scania.setLoadCapacity(TruckLoadCapacity.N3);
        ural.setLoadCapacity(TruckLoadCapacity.N3);
        System.out.println(ural.getLoadCapacity());
        */

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
}