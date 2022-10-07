package transport;

public enum TruckLoadCapacity {
    N1 ("до 3,5 тонн"),
    N2 ("от 3,5 до 12 тонн"),
    N3 ("от 12 тонн");

    private final String description;

    TruckLoadCapacity(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TruckLoadCapacity{" +
                "description='" + description + '\'' +
                '}';
    }
}
