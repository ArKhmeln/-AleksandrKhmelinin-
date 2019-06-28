package hw4.enums.metalsAndColors;

public enum Colors {

    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    final String name;

    Colors(String name) {
        this.name = name;
    }

    public String getText() {
        return name;
    }
}
