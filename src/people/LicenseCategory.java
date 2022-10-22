package people;

public enum LicenseCategory {
    B ("Легковые авто"),
    C ("грузовые авто"),
    D ("автобусы");

    private String category;

    LicenseCategory(String category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return category;
    }
}
