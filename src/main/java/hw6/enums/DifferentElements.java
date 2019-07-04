package hw6.enums;

public enum DifferentElements {

    //checkbox
    WATER("Water"),
    WIND("Wind"),
    //radiobutton
    SELEN("Selen"),
    //dropdown
    YELLOW("Yellow");

    final String name;

    DifferentElements(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
