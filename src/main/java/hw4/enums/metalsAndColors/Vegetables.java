package hw4.enums.metalsAndColors;

public enum Vegetables {

    CUCUMBER("Cucumber"),
    TOMATO("Tomato"),
    VEGETABLES_CHECKBOX("Vegetables"),
    ONION("Onion");

    final String name;

    Vegetables(String name) {
        this.name = name;
    }

    public String getText() {
        return name;
    }
}
