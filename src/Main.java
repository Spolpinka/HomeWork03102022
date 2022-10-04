import transport.Bus;
import transport.Car;
import transport.Transport;
import transport.Truck;

public class Main {
    public static void main(String[] args) {}{

    }

    void task1(){
        //создаем произвольные car
        Transport lada = new Car("Лада", "Веста Sport");
        Transport ferrari = new Car("Ferrari", "296 GTS", 6.0f);
        Transport bugatti = new Car("Bugatti", "Veron", 8.0f);
        Transport uas = new Car("УАЗ", "UAZ-3909");

        //произвольные truck
        Transport volvo = new Truck("Volvo", "FH16", 10.0f);
        Transport scania = new Truck("Scania", "R 410 6 × 2 Highline", 12.0f);
        Transport kamaz = new Truck("КамАЗ", "43118", 12.2f);
        Transport ural = new Truck("Урал", "Урал-375");

        //произвольные bus
        Transport hyundai = new Bus("Hyudai", "County");
        Transport neoplan = new Bus("Neoplan", "Tourliner", 13.6f);
        Transport bogdan = new Bus("БОГДАН", "А201");
        Transport liaz = new Bus("ЛИАЗ", "5250 Вояж");
    }
}