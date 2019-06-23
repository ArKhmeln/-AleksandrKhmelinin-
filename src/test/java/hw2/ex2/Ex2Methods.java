package hw2.ex2;

import hw2.hw2Base.Hw2BaseTest;
import org.openqa.selenium.By;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class Ex2Methods extends Hw2BaseTest {

    //5. Click & assert header dropdown
    // TODO This method looks like code duplication from assertHeaderSectionText Ex1Methods class
    protected void assertHeaderDropdownTextInService(List<String> expectedHeaderDropdown) {
        // TODO Why this method does not return List<String>
        checkText(By.cssSelector("li.dropdown"), By.xpath("//ul[@class='dropdown-menu']//li"));
        assertEquals(actualElements, expectedHeaderDropdown);
        // TODO Is clear required here?
        actualElements.clear();
    }

    //6. Click & assert left dropdown
    // TODO This method looks like code duplication from assertHeaderDropdownTextInService current class
    protected void assertLeftDropdownTextInService(List<String> expectedLeftDropdown) {
        // TODO Why this method does not return List<String>
        checkText(By.cssSelector("li.menu-title"), By.xpath("//li[@class='menu-title' " +
                "and contains(.//span, 'Service')]//li//span"));
        assertEquals(actualElements, expectedLeftDropdown);
        // TODO Is clear required here?
        actualElements.clear();
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

    //Step 10 assert left section
    //11. Select checkboxes
    //Method is in the Base class
    //Method is in the BaseTest

    //12. Assert checkboxes logo rows
    //Method in the Base Test

    //13. Select radio
    //Method is in the Base class

    //14. Assert radiobutton logo row
    //Method is in the Base class


    //15. Select in dropdown
    protected void dropdownSelect(String dropdownOption) {
        driver.findElement(By.cssSelector("select.uui-form-element")).click();
        selectAndClickElementByName(By.cssSelector("select.uui-form-element option"),dropdownOption);
    }

    //16. Assert dropdown log
    //Method is in the Base class

    //17. Unselect checkboxes
    //This method is in the BaseTest

    //18. Assert checkboxes unselect log
    //Method in the Base class
}

