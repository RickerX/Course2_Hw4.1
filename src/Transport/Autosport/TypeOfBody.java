package Transport.Autosport;

public enum TypeOfBody {
    SEDAN("Седан"),
    HATCHBEK("Хэтчбек"),
    COUPE("Купэ"),
    STATION_WAGON("Универсал"),
    SUV("Внедорожник"),
    CROSSOVER("Кроссовер"),
    PICKUP_TRUCK("Пикап"),
    VAN("Фургон"),
    MINIVAN("Минивен");
    private final String typeOfBody;

    TypeOfBody(String typeOfBody) {
        this.typeOfBody = typeOfBody;
    }

    public String getTypeOfBody() {
        return typeOfBody;
    }
}
