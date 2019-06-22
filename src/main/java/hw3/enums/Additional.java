package hw3.enums;

public enum Additional {

    JDI_GITHUB("JDI GITHUB"),
    LINK("https://github.com/epam/JDI");

    final String name;

    Additional(String name) {
        this.name = name;
    }

    public String getText() {
        return name;
    }

}
