package transport;

public enum BusCapacity {
    ESPECIALLY_SMALL ("супер малая"),// (up to 10 seats),
    SMALL ("малая"),// (up to 25),
    MEDIUM ("средняя"),// (40-50),
    LARGE ("большая"),// (60-80),
    ESPECIALLY_LARGE ("супер большая");// (100-120 seats)

    private String name;

    private BusCapacity (String name){
        this.name = name;
    }
}
