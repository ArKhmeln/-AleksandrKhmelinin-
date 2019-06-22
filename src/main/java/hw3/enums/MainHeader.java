package hw3.enums;

import java.util.ArrayList;
import java.util.List;

public enum MainHeader {

    WISHES("EPAM FRAMEWORK WISHES…"),
    TEXT("LOREM IPSUM DOLOR SIT AMET," +
            " CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT" +
            " ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO" +
            " CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT" +
            " NULLA PARIATUR.");


    final String name;

    MainHeader(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> mainHeaderText() {
        List<String> itemsText = new ArrayList<>();
        for(MainHeader item: MainHeader.values()) {
            itemsText.add(item.name);
        }
        return itemsText;
    }
}
