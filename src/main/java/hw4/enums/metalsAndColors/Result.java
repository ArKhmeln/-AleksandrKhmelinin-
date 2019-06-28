package hw4.enums.metalsAndColors;

public enum Result {

    SUMMARY("Summary"),
    NAME("Name"),
    ELEMENTS("Elements"),
    COLOR("Color"),
    METAL("Metal"),
    VEGETABLES("Vegetables");

    final String name;

    Result(String name) {
        this.name = name;
    }

    public String getText() {
        return name;
    }
}
