package hw2.ex2;

import hw2.hw2Base.Hw2BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Ex2Methods extends Hw2BaseTest {

    //5. Click & assert header dropdown
    // TODO What type of elements could contain list?   -fixed
    // TODO This method looks like Ex1Methods.assertHeaderSection   -fixed
    protected void assertHeaderDropdownText(List<String> expectedHeaderDropdown) {
        assertDropdownText(By.cssSelector("li.dropdown"), By.xpath("//ul[@class='dropdown-menu']//li"), true);
        // TODO For collections could be used another assert    -skype
        assertEquals(actualElements, expectedHeaderDropdown);
        actualElements.clear();
    }

    //6. Click & assert left dropdown
    protected void assertLeftDropdownText(List<String> expectedLeftDropdown) {
        // TODO This locator could be improved      -fixed
        // TODO This locator could be improved  -fixed
        // TODO Code duplication    -fixed
        assertDropdownText(By.cssSelector("li.menu-title"), By.xpath("//li[@class='menu-title' " +
                "and contains(.//span, 'Service')]//li//span"), true);
        assertEquals(actualElements, expectedLeftDropdown);
        actualElements.clear();
    }

    //7. Open Service > Different elements
    // TODO Please follow java code convention for the method naming    -fixed
    protected void serviceElementsClick() {
        // TODO This locator could be improved      -fixed
        driver.findElement(By.cssSelector("header .dropdown-toggle")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Different elements')]")).click();
    }


    //8. Assert page elements
    protected void pageElements() {
        int actualCheckboxesAmount = driver.findElements(By.className("label-checkbox")).size();
        assertEquals(actualCheckboxesAmount, 4);
        int actualRadiobuttonsAmount = driver.findElements(By.className("label-radio")).size();
        assertEquals(actualRadiobuttonsAmount, 4);
        int actualDropdownsAmount = driver.findElements(By.cssSelector(".colors>.uui-form-element")).size();
        assertEquals(actualDropdownsAmount, 1);
        int actualButtonsAmount = driver.findElements(By.cssSelector(".main-content-hg>.uui-button")).size();
        assertEquals(actualButtonsAmount, 2);
    }

    //9. Assert right section
    protected void rightSectionExistence() {
        assertTrue(driver.findElement(By.cssSelector("[class~='right-fix-panel']")).isDisplayed());
    }


    //Step 10 assert left section
    // TODO This method looks like Ex1Methods.assertLeftSectionPresence     -fixed

    //11. Select checkboxes
    // TODO This method should be parametrized      -fixed
        // TODO This locators could be improved     -fixed
    //Method is in the BaseTest


    //12. Assert checkboxes logo rows
    //Changed method is in the base test
    // TODO This method should be parametrized      -fixed
        // TODO This locator could be improved      -fixed
        // TODO This locator could be improved      -fixed

    //13. Select radio
    // TODO This method should be parametrized      -fixed
        // TODO This locator could be improved
    protected void selectRadiobutton(String buttonName) {
        List<WebElement> radioButtons = driver.findElements(By.className("label-radio"));
        for(WebElement element: radioButtons) {
            if (element.getText().equals(buttonName)) {
                element.click();
            }
        }
    }

    //14. Assert radiobutton logo row
    // TODO This method should be parametrized      -fixed
    protected void radiobuttonLogo(String radiobuttonLogo) {
        // TODO This locator could be improved
        WebElement selenRadioLogo = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']" +
                "//*[contains(text(), '"+radiobuttonLogo+"')]"));
        assertTrue(selenRadioLogo.isDisplayed());
    }

    //15. Select in dropdown
    // TODO This method should be parametrized      -fixed
    protected void dropdownSelect(int dropdownOption) {
        // TODO This locator could be improved
        driver.findElement(By.cssSelector(".main-content-hg>.colors")).click();
        // TODO This locator could be improved
        driver.findElement(By.xpath("//select/option["+dropdownOption+"]")).click();
    }

    //16. Assert dropdown log
    // TODO This method should be parametrized      -fixed
    protected void dropdownLog(String dropdownLog) {
        // TODO This locator could be improved
        WebElement dropdownLogo = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']" +
                "//*[contains(text(), '"+dropdownLog+"')]"));
        assertTrue(dropdownLogo.isDisplayed());
    }

    //17. Unselect checkboxes
    // TODO This method should be parametrized      -fixed
        // TODO This locator could be improved      -fixed
        // TODO This locator could be improved      -fixed
    //This method is in the BaseTest

    //18. Assert checkboxes unselect log
    // TODO This method should be parametrized      -fixed
    protected void checkboxUnselectLog(String checkboxUnselectLog1, String checkboxUnselectLog2) {
        // TODO This locator could be improved
        WebElement waterUnselectLogo = driver.findElement(By.xpath(" //ul[@class='panel-body-list logs']" +
                "//*[contains(text(),'"+checkboxUnselectLog1+"')]"));
        assertTrue(waterUnselectLogo.isDisplayed());
        // TODO This locator could be improved
        WebElement windUnselectLogo = driver.findElement(By.xpath(" //ul[@class='panel-body-list logs']" +
                "//*[contains(text(),'"+checkboxUnselectLog2+"')]"));
        assertTrue(windUnselectLogo.isDisplayed());
    }
}

