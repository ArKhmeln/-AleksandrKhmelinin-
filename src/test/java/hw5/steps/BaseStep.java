package hw5.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BaseStep {

    protected WebDriver driver;

    protected BaseStep() {}

    protected void assertSectionPresence(WebElement element) {
        assertTrue(element.isDisplayed());
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
}
