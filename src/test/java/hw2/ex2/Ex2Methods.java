package hw2.ex2;

import hw2.hw2Base.Hw2BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Ex2Methods extends Hw2BaseTest {

    //5. Click & assert header dropdown
    protected void headerDropdown(List expectedHeaderDropdown) {
        driver.findElement(By.cssSelector("li.dropdown")).click();
        List<String> actualHeaderDropdown = new ArrayList<>();
        List<WebElement> headerDropdown = driver.findElements(By.cssSelector("ul.dropdown-menu>li"));
        for(WebElement element: headerDropdown) {
            actualHeaderDropdown.add(element.getText());
        }
        assertEquals(actualHeaderDropdown, expectedHeaderDropdown);
    }

    //6. Click & assert left dropdown
    protected void leftDropdown(List expectedLeftDropdown) {
        driver.findElement(By.cssSelector("li.menu-title[index='3']")).click();
        List<String> actualLeftDropdown = new ArrayList<>();
        List<WebElement> leftDropdown = driver.findElements(By.cssSelector(".menu-title[index='3']>.sub span"));
        for(WebElement element: leftDropdown) {
            actualLeftDropdown.add(element.getText());
        }
        assertEquals(actualLeftDropdown, expectedLeftDropdown);
    }

    //7. Open Service > Different elements
    protected void serviceElementsclick() {
        driver.findElement(By.cssSelector("li.menu-title[index='3'] li[index='8']")).click();
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
    protected void leftSectionExistence() {
        assertTrue(driver.findElement(By.className("sidebar-menu")).isDisplayed());
    }

    //11. Select checkboxes
    protected void selectCheckbox() {
        driver.findElement(By.xpath("//label[@class='label-checkbox'][1]")).click();
        driver.findElement(By.xpath("//label[@class='label-checkbox'][3]")).click();
    }

    //12. Assert checkboxes logo rows
    protected void checkboxLogo() {
        WebElement waterCheckboxLogo = driver.findElement(By.xpath(" //ul[@class='panel-body-list logs']" +
                "//*[contains(text(),'Water: condition changed to true')]"));
        assertTrue(waterCheckboxLogo.isDisplayed());
        WebElement windCheckboxLogo = driver.findElement(By.xpath(" //ul[@class='panel-body-list logs']" +
                "//*[contains(text(),'Wind: condition changed to true')]"));
        assertTrue(windCheckboxLogo.isDisplayed());
    }

    //13. Select radio
    protected void radiobutton() {
        driver.findElement(By.xpath("//label[@class='label-radio'][4]")).click();
    }

    //14. Assert radiobutton logo row
    protected void radiobuttonLogo() {
        WebElement selenRadioLogo = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']" +
                "//*[contains(text(), 'metal: value changed to  Selen')]"));
        assertTrue(selenRadioLogo.isDisplayed());
    }

    //15. Select in dropdown
    protected void dropdownSelect() {
        driver.findElement(By.cssSelector(".main-content-hg>.colors")).click();
        driver.findElement(By.xpath("//select/option[4]")).click();
    }

    //16. Assert dropdown log
    protected void dropdownLog() {
        WebElement dropdownLogo = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']" +
                "//*[contains(text(), 'Colors: value changed to Yellow')]"));
        assertTrue(dropdownLogo.isDisplayed());
    }

    //17. Unselect checkboxes
    protected void unselectCheckbox() {
        driver.findElement(By.xpath("//label[@class='label-checkbox'][1]")).click();
        driver.findElement(By.xpath("//label[@class='label-checkbox'][3]")).click();
    }

    //18. Assert checkboxes unselect log
    protected void checkboxUnselectLog() {
        WebElement waterUnselectLogo = driver.findElement(By.xpath(" //ul[@class='panel-body-list logs']" +
                "//*[contains(text(),'Water: condition changed to false')]"));
        assertTrue(waterUnselectLogo.isDisplayed());
        WebElement windUnselectLogo = driver.findElement(By.xpath(" //ul[@class='panel-body-list logs']" +
                "//*[contains(text(),'Wind: condition changed to false')]"));
        assertTrue(windUnselectLogo.isDisplayed());
    }
}

