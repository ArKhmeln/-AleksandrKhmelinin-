package hw2.ex1;

import base.BaseTest;
import base.BaseTest2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise1 extends BaseTest2 {

    @Test
    public void loginTest() {
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

        //Step 5 assert browser title
        assertEquals(driver.getTitle(), "Home Page");
    }

    @Test
    public void pageElementsTests() {
        //Step 6 assert header section
        List<WebElement> headerItems = driver.findElements(By.cssSelector("ul[class$='navbar-nav m-l8']>li>a[href]"));
        List<String> itemsNames = new ArrayList<>();
        for(WebElement element : headerItems) {
            itemsNames.add(element.getText());
        }
        WebElement services = driver.findElement(By.cssSelector("ul[class$='navbar-nav m-l8'] a.dropdown-toggle"));
        itemsNames.add(2, services.getText());
        List<String> headerExpected = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        assertEquals(itemsNames, headerExpected);

        //Step 7 index page images
        List<WebElement> images = driver.findElements(By.
                cssSelector("div[class='row clerafix benefits'] .benefit-icon"));
        for(WebElement element : images) {
            assertTrue(element.isDisplayed());
        }

        //Step 8 icon texts
        List<WebElement> iconTexts = driver.findElements(By.cssSelector(".main-content .benefit-txt"));
        List<String> actualIconText = new ArrayList<>();
        for(WebElement element : iconTexts) {
            actualIconText.add(element.getText());
        }
        List<String> expectedIconText = Arrays.asList("To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project", "To be flexible and\n" +
                "customizable", "To be multiplatform", "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");
        assertEquals(actualIconText, expectedIconText);

        //Step 9 main header text
        List<WebElement> mainHeaderText = driver.findElements(By.cssSelector("[class$='text-center']:nth-child(-n+2)"));
        List<String> actualMainHeaderText = new ArrayList<>();
        for(WebElement element : mainHeaderText) {
            actualMainHeaderText.add(element.getText());
        }
        List<String> expectedMainHeaderText = Arrays.asList("EPAM FRAMEWORK WISHES…", "LOREM IPSUM DOLOR SIT AMET," +
                " CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT" +
                " ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO" +
                " CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT" +
                " NULLA PARIATUR.");
        assertEquals(actualMainHeaderText, expectedMainHeaderText);

        //Step 10 inframe existence
        WebElement inframe = driver.findElement(By.id("iframe"));
        assertTrue(inframe.isDisplayed());

        //Step 11 switch to the inframe, check EPAM logo
        driver.switchTo().frame("iframe");
        WebElement iframeEPAMLogo = driver.findElement(By.id("epam_logo"));
        assertTrue(iframeEPAMLogo.isDisplayed());

        //Step 12 switch to original window
        driver.switchTo().defaultContent();

        //Step 13 assert sub header text
        WebElement subHeader = driver.findElement(By.cssSelector(".text-center>a"));
        String expectedSubHeader = "JDI GITHUB";
        assertEquals(subHeader.getText(), expectedSubHeader);

        //Step 14 assert sub header link
        assertTrue(driver.findElement(By.linkText("JDI GITHUB")).isDisplayed());
        String actualSubHeaderLink = subHeader.getAttribute("href");
        String expectedSubHeaderLink = "https://github.com/epam/JDI";
        assertEquals(actualSubHeaderLink, expectedSubHeaderLink);

        //Step 15 assert left section
        assertTrue(driver.findElement(By.id("mCSB_1")).isDisplayed());

        //Step 16 assert footer
        assertTrue(driver.findElement(By.cssSelector(".footer-bg")).isDisplayed());

        //Step 17 close browser is in the BaseTest class
    }
}
