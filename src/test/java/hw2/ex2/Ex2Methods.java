package hw2.ex2;

import hw2.hw2Base.Hw2BaseTest;
import org.openqa.selenium.By;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Ex2Methods extends Hw2BaseTest {

    //5. Click & assert header dropdown
    // TODO What type of elements could contain list?   -fixed
    // TODO This method looks like Ex1Methods.assertHeaderSection   -fixed
    protected void assertHeaderDropdownTextInService(List<String> expectedHeaderDropdown) {
        checkText(By.cssSelector("li.dropdown"), By.xpath("//ul[@class='dropdown-menu']//li"));
        // TODO For collections could be used another assert    -skype
        assertEquals(actualElements, expectedHeaderDropdown);
        actualElements.clear();
    }

    //6. Click & assert left dropdown
    protected void assertLeftDropdownTextInService(List<String> expectedLeftDropdown) {
        // TODO This locator could be improved      -fixed
        // TODO This locator could be improved  -fixed
        // TODO Code duplication    -fixed
        checkText(By.cssSelector("li.menu-title"), By.xpath("//li[@class='menu-title' " +
                "and contains(.//span, 'Service')]//li//span"));
        assertEquals(actualElements, expectedLeftDropdown);
        actualElements.clear();
    }

    //7. Open Service > Different elements
    // TODO Please follow java code convention for the method naming    -fixed
    protected void goToServiceDifferentElementsInHeader() {
        // TODO This locator could be improved      -fixed
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

    //9. Assert right section
    protected void assertRightSectionPresence() {
        assertTrue(driver.findElement(By.cssSelector("[class~='right-fix-panel']")).isDisplayed());
    }


    //Step 10 assert left section
    // TODO This method looks like Ex1Methods.assertLeftSectionPresence     -fixed

    //11. Select checkboxes
    protected void selectCheckbox(String checkboxName) {
        selectAndClickElement(By.className("label-checkbox"), checkboxName);
    }
    // TODO This method should be parametrized      -fixed
        // TODO This locators could be improved     -fixed
    //Method is in the BaseTest


    //12. Assert checkboxes logo rows
    //Method in the Base Test
    // TODO This method should be parametrized      -fixed
        // TODO This locator could be improved      -fixed
        // TODO This locator could be improved      -fixed

    //13. Select radio
    // TODO This method should be parametrized      -fixed
        // TODO This locator could be improved      -fixed
    protected void selectRadiobutton(String buttonName) {
        selectAndClickElement(By.className("label-radio"), buttonName);
    }

    //14. Assert radiobutton logo row
    //Method is in the Base class
    // TODO This method should be parametrized      -fixed
        // TODO This locator could be improved      -fixed


    //15. Select in dropdown
    // TODO This method should be parametrized      -fixed
        // TODO This locator could be improved      -fixed
        // TODO This locator could be improved      -fixed
    protected void dropdownSelect(String dropdownOption) {
        driver.findElement(By.cssSelector("select.uui-form-element")).click();
        selectAndClickElement(By.cssSelector("select.uui-form-element option"),dropdownOption);
    }

    //16. Assert dropdown log
    //Method is in the Base class
    // TODO This method should be parametrized      -fixed
        // TODO This locator could be improved      -fixed

    //17. Unselect checkboxes
    // TODO This method should be parametrized      -fixed
        // TODO This locator could be improved      -fixed
        // TODO This locator could be improved      -fixed
    //This method is in the BaseTest

    //18. Assert checkboxes unselect log
    //Method in the Base class
    // TODO This method should be parametrized      -fixed
        // TODO This locator could be improved      -fixed
        // TODO This locator could be improved      -fixed
}

