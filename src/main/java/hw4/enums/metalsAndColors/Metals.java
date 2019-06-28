package hw4.enums.metalsAndColors;

public enum Metals {

    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    final String name;

    Metals(String name) {
        this.name = name;
    }

    public String getText() {
        return name;
    }
}
