package hw6.enums;

public enum UserTables {

    SERGEY_IVAN("Sergey Ivan"),
    ROMAN("Roman");

    final String text;

    UserTables(String name) {
        this.text = name;
    }

    public String getText() {
        return text;
    }

}
