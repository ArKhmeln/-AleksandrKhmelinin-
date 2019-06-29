package hw4.Ex2;

import hw4.builder.MetalsAndColorsData;
import hw4.hw4Base.BaseTest;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

import static hw4.enums.metalsAndColors.Colors.*;
import static hw4.enums.metalsAndColors.Elements.*;
import static hw4.enums.metalsAndColors.Elements.FIRE;
import static hw4.enums.metalsAndColors.Metals.*;
import static hw4.enums.metalsAndColors.Vegetables.*;
import static hw4.enums.metalsAndColors.Vegetables.VEGETABLES_CHECKBOX;

public class Ex2DataProvider extends BaseTest {

    @DataProvider(name = "builder")
    public static Object[][] builder() {
        return new Object[][] {
                {MetalsAndColorsData.builder()
                        .elements(Arrays.asList(EARTH))
                        .colors(YELLOW.getText())
                        .metals(GOLD.getText())
                        .build()
                },
                {MetalsAndColorsData.builder()
                        .summary(Arrays.asList("3", "8"))
                        .vegetables(Arrays.asList(CUCUMBER, TOMATO))
                        .build()
                },
                {MetalsAndColorsData.builder()
                        .summary(Arrays.asList("3", "2"))
                        .elements(Arrays.asList(WIND, FIRE, EARTH))
                        .metals(BRONZE.getText())
                        .vegetables(Arrays.asList(ONION))
                        .build()
                },
                {MetalsAndColorsData.builder()
                        .summary(Arrays.asList("6", "5"))
                        .elements(Arrays.asList(WATER))
                        .colors(GREEN.getText())
                        .metals(SELEN.getText())
                        .vegetables(Arrays.asList(CUCUMBER, TOMATO, ONION, VEGETABLES_CHECKBOX))
                        .build()
                },
                {MetalsAndColorsData.builder()
                        .elements(Arrays.asList(FIRE))
                        .colors(BLUE.getText())
                        .vegetables(Arrays.asList(CUCUMBER, TOMATO, VEGETABLES_CHECKBOX))
                        .build()
                }
        };
    }
}
