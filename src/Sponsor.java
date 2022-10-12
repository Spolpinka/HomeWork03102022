public class Sponsor {
    private String name;
    private int amount;

    public Sponsor(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void sponsorRace(int amountForRace) throws NotEnoughAmountException {
        int dif = amount - amountForRace;
        if (dif >= 0) {
            amount = dif;
        } else {
            throw new NotEnoughAmountException("не хватило денег у спонсора " + this.name, this);
        }
    }
}
