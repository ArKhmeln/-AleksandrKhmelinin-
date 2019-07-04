package hw6.enums;

public enum WebsiteAndUserInfo {

    LINK_MAIN("https://epam.github.io/JDI/"),
    JDI_GITHUB("JDI GITHUB"),
    MAIN_TITLE("Home Page"),
    USER_TABLE_TITLE("User Table"),
    USER_NAME("PITER CHAILOVSKII"),
    LOGIN("epam"),
    PASSWORD("1234");

    final String name;

    WebsiteAndUserInfo(String name) {
        this.name = name;
    }

    public String getText() {
        return name;
    }

}
