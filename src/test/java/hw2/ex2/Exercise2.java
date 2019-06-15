
package hw2.ex2;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise2 extends BaseTest {

    @Test
    public void ex2EpamSiteTests() {
        //Step 1 "go to the site" is in the BaseTest class
        //Step 2 assert browser title
        assertEquals(driver.getTitle(), "Home Page");

        //Step 3 login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("epam");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("login-button")).click();

        //Step 4 assert user name
        assertEquals(driver.findElement(By.id("user-name")).getText(), "PITER CHAILOVSKII");

        //Step 5 click & assert header dropdown
        driver.findElement(By.cssSelector("li.dropdown")).click();
        List<String> actualHeaderDropdown = new ArrayList<>();
        List<WebElement> headerDropdown = driver.findElements(By.cssSelector("ul.dropdown-menu>li"));
        for(WebElement element: headerDropdown) {
            actualHeaderDropdown.add(element.getText());
        }
        List<String> expectedHeaderDropdown = Arrays.asList("SUPPORT", "DATES", "SEARCH", "COMPLEX TABLE",
                "SIMPLE TABLE", "USER TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE");
        assertEquals(actualHeaderDropdown, expectedHeaderDropdown);

        //Step 6 click & assert left dropdown
        //!in the exercise data description there are slight differences with actual left dropdown menu in the website
        driver.findElement(By.cssSelector("li.menu-title[index='3']")).click();
        List<String> actualLeftDropdown = new ArrayList<>();
        List<WebElement> leftDropdown = driver.findElements(By.cssSelector(".menu-title[index='3']>.sub span"));
        for(WebElement element: leftDropdown) {
            actualLeftDropdown.add(element.getText());
        }
        List<String> expectedLeftDropdown = Arrays.asList("Support", "Dates", "Complex Table",
                "Simple Table", "Search", "User Table", "Table with pages", "Different elements", "Performance");
        assertEquals(actualLeftDropdown, expectedLeftDropdown);

        //Step 7 open Service > Different elements
        driver.findElement(By.cssSelector("li.menu-title[index='3'] li[index='8']")).click();

        //Step 8 assert page elements
        int actualCheckboxesAmount = driver.findElements(By.className("label-checkbox")).size();
        assertEquals(actualCheckboxesAmount, 4);
        int actualRadiobuttonsAmount = driver.findElements(By.className("label-radio")).size();
        assertEquals(actualRadiobuttonsAmount, 4);
        int actualDropdownsAmount = driver.findElements(By.cssSelector(".colors>.uui-form-element")).size();
        assertEquals(actualDropdownsAmount, 1);
        int actualButtonsAmount = driver.findElements(By.cssSelector(".main-content-hg>.uui-button")).size();
        assertEquals(actualButtonsAmount, 2);

        //Step 9 assert right section
        assertTrue(driver.findElement(By.cssSelector("[class~='right-fix-panel']")).isDisplayed());

        //Step 10 assert left section
        assertTrue(driver.findElement(By.className("sidebar-menu")).isDisplayed());

        //Step 11 select checkboxes
        driver.findElement(By.xpath("//label[@class='label-checkbox'][1]")).click();
        driver.findElement(By.xpath("//label[@class='label-checkbox'][3]")).click();

        //Step 12 assert checkboxes logo rows
        WebElement waterCheckboxLogo = driver.findElement(By.xpath(" //ul[@class='panel-body-list logs']" +
                "//*[contains(text(),'Water: condition changed to true')]"));
        assertTrue(waterCheckboxLogo.isDisplayed());
        WebElement windCheckboxLogo = driver.findElement(By.xpath(" //ul[@class='panel-body-list logs']" +
                "//*[contains(text(),'Wind: condition changed to true')]"));
        assertTrue(windCheckboxLogo.isDisplayed());

        //Step 13 select radio
        driver.findElement(By.xpath("//label[@class='label-radio'][4]")).click();

        //Step 14 assert radio logo
        WebElement selenRadioLogo = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']" +
                "//*[contains(text(), 'metal: value changed to  Selen')]"));
        assertTrue(selenRadioLogo.isDisplayed());

        //Step 15 select in dropdown
        driver.findElement(By.cssSelector(".main-content-hg>.colors")).click();
        driver.findElement(By.xpath("//select/option[4]")).click();

        //Step 16 assert dropdown log
        WebElement dropdownLogo = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']" +
                "//*[contains(text(), 'Colors: value changed to Yellow')]"));
        assertTrue(dropdownLogo.isDisplayed());

        //Step 17 unselect checkboxes
        driver.findElement(By.xpath("//label[@class='label-checkbox'][1]")).click();
        driver.findElement(By.xpath("//label[@class='label-checkbox'][3]")).click();

        //Step 18 assert checkboxes unselect log
        WebElement waterUnselectLogo = driver.findElement(By.xpath(" //ul[@class='panel-body-list logs']" +
                "//*[contains(text(),'Water: condition changed to false')]"));
        assertTrue(waterUnselectLogo.isDisplayed());
        WebElement windUnselectLogo = driver.findElement(By.xpath(" //ul[@class='panel-body-list logs']" +
                "//*[contains(text(),'Wind: condition changed to false')]"));
        assertTrue(windUnselectLogo.isDisplayed());
    }
}
