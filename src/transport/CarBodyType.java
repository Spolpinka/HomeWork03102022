package transport;

public enum CarBodyType {
    SEDAN ("седан цвета баклажан"),
    HATCHBACK ("хэтчбэк"),
    COUPE ("купе"),
    MULTIPURPOSE_VEHICLE ("многоцелевое"),
    SUV ("внедорожник"),
    CROSSOVER("кроссовер"),
    PICKUP("пикап"),
    VAN("фургон"),
    MINIVAN("минивэн");

    private String name;

    private CarBodyType(String name) {
        this.name = name;
    }
}
