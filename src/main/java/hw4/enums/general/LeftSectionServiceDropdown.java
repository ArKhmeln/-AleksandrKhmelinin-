package hw4.enums.general;

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

    public static List<String> getLeftSectionServiceDropdownText() {
        List<String> sectionText = new ArrayList<>();
        for(LeftSectionServiceDropdown item: LeftSectionServiceDropdown.values()) {
            sectionText.add(item.name);
        }
        return sectionText;
    }
}
