package transport;

public enum BusCapacity {
    ESPECIALLY_SMALL ("особо малая", "up to 10 seats"),
    SMALL ("малая", "up to 25"),
    MEDIUM ("средняя", "40-50"),
    LARGE ("большая", "60-80"),
    ESPECIALLY_LARGE ("особо большая","100-120 seats");

    private String name;

    private String description;

    private BusCapacity (String name, String description){
        this.name = name;
        this.description = description;
    }
}
