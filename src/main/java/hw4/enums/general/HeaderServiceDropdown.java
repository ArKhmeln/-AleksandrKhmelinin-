package hw4.enums.general;

import java.util.ArrayList;
import java.util.List;

public enum HeaderServiceDropdown {
    SUPPORT("SUPPORT"),
    DATES("DATES"),
    SEARCH("SEARCH"),
    COMPLEXTABLE("COMPLEX TABLE"),
    SIMPLETABLE("SIMPLE TABLE"),
    USERTABLE("USER TABLE"),
    TABLEWITHPAGES("TABLE WITH PAGES"),
    DIFFERENTELEMENTS("DIFFERENT ELEMENTS"),
    PERFORMANCE("PERFORMANCE");


    final String name;

    HeaderServiceDropdown(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> getHeaderServiceDropdownText() {
        List<String> itemsText = new ArrayList<>();
        for(HeaderServiceDropdown item: HeaderServiceDropdown.values()) {
            itemsText.add(item.name);
        }
        return itemsText;
    }
}
