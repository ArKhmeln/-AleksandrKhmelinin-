package hw5.enums;

public enum WebsiteInfo {

    LINK_MAIN("https://epam.github.io/JDI/"),
    JDI_GITHUB("JDI GITHUB"),
    LINK_JDI("https://github.com/epam/JDI"),
    TITLE("Home Page"),
    USER_NAME("PITER CHAILOVSKII1");
    final String name;

    WebsiteInfo(String name) {
        this.name = name;
    }

    public String getText() {
        return name;
    }

}
