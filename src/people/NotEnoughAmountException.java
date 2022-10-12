package people;

import people.Sponsor;

public class NotEnoughAmountException extends Exception {
    private String message;
    private Sponsor sponsor;

    public NotEnoughAmountException(String message, Sponsor sponsor) {
        super(message);
        this.sponsor = sponsor;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }
}
