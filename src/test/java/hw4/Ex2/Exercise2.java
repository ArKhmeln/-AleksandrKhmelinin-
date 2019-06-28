package hw4.Ex2;

import hw4.builder.MetalsAndColorsData;
import hw4.enums.metalsAndColors.Elements;
import hw4.enums.metalsAndColors.Vegetables;
import hw4.pages.MetalsAndColors;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static hw4.enums.metalsAndColors.Result.*;
import static hw4.enums.metalsAndColors.Vegetables.VEGETABLES_CHECKBOX;

public class Exercise2 extends Ex2DataProvider {

    @Test(dataProvider = "builder")
    public void metalsAndColorsTest(MetalsAndColorsData build) {
        MetalsAndColors metalsAndColors = new MetalsAndColors();
        //4. Click on the link on the Header section
        homePage.goToMetalsAndColors();
        //5. Fill form on the page
        metalsAndColors.selectSummary(build.getSummary());
        metalsAndColors.selectElements(build.getElements());
        metalsAndColors.selectColor(build.getColors());
        metalsAndColors.selectMetal(build.getMetals());
        metalsAndColors.selectVegetables(build.getVegetables());
        //6. Click “Submit” button
        metalsAndColors.clickSubmitButton();
        //7. Check Results block output on the right-side
            //Check Summary
        if(build.getSummary() != null) {
            if(!metalsAndColors.getSummaryResult(build.getSummary()).equals("3")) {
                metalsAndColors.getResult(SUMMARY).shouldHave(
                        text(metalsAndColors.getSummaryResult(build.getSummary())));
            }
        }
            //Check Element
        if(build.getElements()!= null) {
            for (Elements element : build.getElements()) {
                metalsAndColors.getResult(ELEMENTS).shouldHave(text(element.getText()));
            }
        }
            //Check Color
        if (build.getColors() != null) {
            if(!build.getColors().equals(COLOR.getText())) {
                metalsAndColors.getResult(COLOR).shouldHave(text(build.getColors()));
            }
        }
            //Check Metal
        if (build.getMetals() != null) {
            if (!build.getMetals().equals(METAL.getText())) {
                metalsAndColors.getResult(METAL).shouldHave(text(build.getMetals()));
            }
        }
            //Check Vegetable
        if (build.getVegetables() != null) {
            if(!build.getVegetables().contains(VEGETABLES_CHECKBOX) || build.getVegetables().size() != 1) {
                for (Vegetables vegetable: build.getVegetables()) {
                    metalsAndColors.getResult(VEGETABLES).shouldHave(text(vegetable.getText()));
                }
            }
        }
    }
}
