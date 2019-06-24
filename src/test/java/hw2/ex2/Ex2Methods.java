package hw2.ex2;

import hw2.hw2Base.Hw2BaseTest;
import org.openqa.selenium.By;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class Ex2Methods extends Hw2BaseTest {

    //5. Click & assert header dropdown
    // TODO This method looks like code duplication from assertHeaderSectionText Ex1Methods class   -fixed
    protected void assertHeaderDropdownTextInService(List<String> expectedHeaderDropdown) {
        // TODO Why this method does not return List<String>    -fixed
        clickAndCheckTextEquality(By.cssSelector("li.dropdown"),
                By.xpath("//ul[@class='dropdown-menu']//li"), expectedHeaderDropdown);
        // TODO Is clear required here?    -fixed
    }

    //6. Click & assert left dropdown
    // TODO This method looks like code duplication from assertHeaderDropdownTextInService current class    -fixed
    protected void assertLeftDropdownTextInService(List<String> expectedLeftDropdown) {
        // TODO Why this method does not return List<String>    -fixed
        clickAndCheckTextEquality(By.cssSelector("li.menu-title"), By.xpath("//li[@class='menu-title' " +
                "and contains(.//span, 'Service')]//li//span"), expectedLeftDropdown);
        // TODO Is clear required here?    -fixed
    }

    //7. Open Service > Different elements
    protected void goToServiceDifferentElementsInHeader() {
        driver.findElement(By.cssSelector("header .dropdown-toggle")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Different elements')]")).click();
    }

    //8. Assert page elements
    protected void assertPageElementsPresence() {
        int actualCheckboxesAmount = driver.findElements(By.className("label-checkbox")).size();
        assertEquals(actualCheckboxesAmount, 4);
        int actualRadiobuttonsAmount = driver.findElements(By.className("label-radio")).size();
        assertEquals(actualRadiobuttonsAmount, 4);
        int actualDropdownsAmount = driver.findElements(By.cssSelector(".colors>.uui-form-element")).size();
        assertEquals(actualDropdownsAmount, 1);
        int actualButtonsAmount = driver.findElements(By.cssSelector(".main-content-hg>.uui-button")).size();
        assertEquals(actualButtonsAmount, 2);
    }

    //15. Select in dropdown
    protected void dropdownSelect(String dropdownOption) {
        driver.findElement(By.cssSelector("select.uui-form-element")).click();
        selectAndClickElementByName(("dropdown"),dropdownOption);
    }

    protected void clickAndCheckTextEquality(By clickSelector, By textToCheck, List<String> expectedElements) {
        driver.findElement(clickSelector).click();
        List<String> actualElements = getTextFromElements(textToCheck);
        assertEquals(actualElements, expectedElements);
    }
}

