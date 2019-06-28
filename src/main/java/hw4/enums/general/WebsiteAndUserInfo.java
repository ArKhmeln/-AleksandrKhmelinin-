package hw4.enums.general;

public enum WebsiteAndUserInfo {

    LINK_MAIN("https://epam.github.io/JDI/"),
    PAGE_TITLE("Home Page"),
    LOGIN("epam"),
    PASSWORD("1234"),
    USER_NAME("PITER CHAILOVSKII"),
    SEARCH_TEXT("Custom");

    final String name;

    WebsiteAndUserInfo(String name) {
        this.name = name;
    }

    public String getText() {
        return name;
    }

}
