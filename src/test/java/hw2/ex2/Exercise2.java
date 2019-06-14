package hw2.ex2;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Exercise2 extends BaseTest {

    @Test
    public void ex2EpamSiteTests() {
        //Step 1 go to the site is in the BaseTest class
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
        driver.findElement(By.cssSelector("li.menu-title[index='3']"));
        List<String> actualLeftDropdown = new ArrayList<>();
        List<WebElement> leftDropdown = driver.findElements(By.cssSelector(".menu-title[index='3']>.sub span"));
        for(WebElement element: leftDropdown) {
            actualLeftDropdown.add(element.getText());  //fix needed
        }
        System.out.println(actualLeftDropdown);
        List<String> expectedLeftDropdown = Arrays.asList("SUPPORT", "DATES", "SEARCH", "COMPLEX TABLE",
                "SIMPLE TABLE", "USER TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE");
    }
}
