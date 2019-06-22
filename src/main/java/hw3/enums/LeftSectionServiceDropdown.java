package hw3.enums;

import java.util.ArrayList;
import java.util.List;

public enum LeftSectionServiceDropdown {

    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEXTABLE("Complex Table"),
    SIMPLETABLE("Simple Table"),
    SEARCH("Search"),
    USERTABLE("User Table"),
    TABLEWITHPAGES("Table with pages"),
    DIFFERENTELEMENTS("Different elements"),
    PERFORMANCE("Performance");

    final String name;

    LeftSectionServiceDropdown(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> leftSectionServiceDropdownText() {
        List<String> itemsText = new ArrayList<>();
        for(LeftSectionServiceDropdown item: LeftSectionServiceDropdown.values()) {
            itemsText.add(item.name);
        }
        return itemsText;
    }
}
