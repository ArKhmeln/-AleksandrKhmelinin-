package hw5.enums;

import java.util.ArrayList;
import java.util.List;

public enum PageIcons {
    SUCCESS("To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM project"),
    FLEXIBLE("To be flexible and\n" +
            "customizable"),
    MULTIPLATFORM("To be multiplatform"),
    GOODBASE("Already have good base\n" +
            "(about 20 internal and\n" +
            "some external projects),\n" +
            "wish to get more…");

    final String name;

    PageIcons(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> pageIconsText() {
        List<String> text = new ArrayList<>();
        for(PageIcons item: PageIcons.values()) {
            text.add(item.name);
        }
        return text;
    }
}
