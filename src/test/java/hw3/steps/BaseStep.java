package hw3.steps;

import hw3.enums.DifferentElements;
import hw3.enums.LogTexts;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public abstract class BaseStep {

    protected List<String> actualElements = new ArrayList<>();

    //Assert section presence
    protected void assertSectionPresence(WebElement element) {
        assertTrue(element.isDisplayed());
    }

    //11, 15, 17 Select/unselect checkboxes, radiobutton, dropdown
    protected void selectAndClickElementByName(List<WebElement> items, DifferentElements elementName) {
        for(WebElement element: items) {
            if (element.getText().equals(elementName.getName())) {
                element.click();
            }
        }
    }

    //12,14,16,18 Logo rows
    protected boolean checkLogoText(List<WebElement> logoElements, LogTexts searchingText) {
        for (WebElement element : logoElements) {
            if (element.getText().endsWith(searchingText.getText())) {
                return true;
            }
        }
        return false;
    }

    //Click(optional) and assert text
    protected void checkText(WebElement elementToClick, List<WebElement> elementsList) {
        if (elementToClick != null) {
            elementToClick.click();
        }
        for (WebElement element : elementsList) {
            actualElements.add(element.getText());
        }
    }
}
