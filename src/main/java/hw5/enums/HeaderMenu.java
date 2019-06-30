package hw5.enums;

import java.util.ArrayList;
import java.util.List;

public enum HeaderMenu {

    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_AND_COLORS("METALS & COLORS");

    final String name;

    HeaderMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> headerMenuItems() {
        List<String> menuItemsText = new ArrayList<>();
        for(HeaderMenu item: HeaderMenu.values()) {
            menuItemsText.add(item.name);
        }
        return menuItemsText;
    }
}
