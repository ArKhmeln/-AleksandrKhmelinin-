package hw3.steps;

import hw3.enums.LogTexts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BaseStep {

    protected WebDriver driver;

    protected BaseStep() {}

    //Assert section presence
    protected void assertSectionPresence(WebElement element) {
        assertTrue(element.isDisplayed());
    }

    protected void findElementByName(List<WebElement> buttons, String elementName) {
        for(WebElement element: buttons) {
            if (element.getText().equals(elementName)) {
                element.click();
                break;
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

    protected List<String> getTextFromElements(List<WebElement> elementsList) {
        List<String> actualElements = new ArrayList<>();
        for(WebElement element: elementsList) {
            actualElements.add(element.getText());
        }
        return actualElements;
    }

    protected void checkTextEquality(List<WebElement> textToCheck, List<String> expectedElements) {
        List<String> actualElements = getTextFromElements(textToCheck);
        assertEquals(actualElements, expectedElements);
    }

    protected void clickAndCheckTextEquality(WebElement clickElement, List<WebElement> textToCheck,
                                             List<String> expectedElements) {
        clickElement.click();
        List<String> actualElements = getTextFromElements(textToCheck);
        assertEquals(actualElements, expectedElements);
    }
}
