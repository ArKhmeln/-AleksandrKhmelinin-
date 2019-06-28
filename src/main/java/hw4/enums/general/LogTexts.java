package hw4.enums.general;

public enum LogTexts {

    LENGTH_10("length, new value=10");

    final String text;

    LogTexts(String name) {
        this.text = name;
    }

    public String getText() {
        return text;
    }
}