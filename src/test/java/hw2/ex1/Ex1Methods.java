package hw2.ex1;

import hw2.hw2Base.Hw2BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class Ex1Methods extends Hw2BaseTest {
    //6. Assert header section
    public void assertHeadersection(List headerExpected) {
        List<WebElement> headerItems = driver.findElements(By.cssSelector("ul[class$='navbar-nav m-l8']>li>a[href]"));
        List<String> itemsNames = new ArrayList<>();
        for(WebElement element : headerItems) {
            itemsNames.add(element.getText());
        }
        WebElement services = driver.findElement(By.cssSelector("ul[class$='navbar-nav m-l8'] a.dropdown-toggle"));
        itemsNames.add(2, services.getText());

        assertEquals(itemsNames, headerExpected);
    }

    //7. Assert index page images
    public void pageImagesExistence() {
        List<WebElement> images = driver.findElements(By.
                cssSelector("div[class='row clerafix benefits'] .benefit-icon"));
        for(WebElement element : images) {
            assertTrue(element.isDisplayed());
        }
    }

    //8. Assert icon texts
    public void iconTextsDisplayed() {
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
    }

    //9. Assert main header text
    public void mainHeaderText() {
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
    }

    //10. Assert inframe existence
    public void inframeExistence() {
        WebElement inframe = driver.findElement(By.id("iframe"));
        assertTrue(inframe.isDisplayed());
    }

    //11. Switch to the inframe, check EPAM logo
    public void iframeEpamLogo() {
        driver.switchTo().frame("iframe");
        WebElement iframeEPAMLogo = driver.findElement(By.id("epam_logo"));
        assertTrue(iframeEPAMLogo.isDisplayed());
    }

    //12. Switch to original window
    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }

    //13. Assert sub header text
    public void subheaderText(String expectedSubHeader) {
        WebElement subHeader = driver.findElement(By.cssSelector(".text-center>a"));
        assertEquals(subHeader.getText(), expectedSubHeader);
    }

    //14 Assert sub header link
    public void subheaderLink(String expectedSubHeaderLink) {
        assertTrue(driver.findElement(By.linkText("JDI GITHUB")).isDisplayed());
        WebElement subHeader = driver.findElement(By.cssSelector(".text-center>a"));
        String actualSubHeaderLink = subHeader.getAttribute("href");
        assertEquals(actualSubHeaderLink, expectedSubHeaderLink);
    }

    //15. Assert left section
    public void leftSectionExistence() {
        assertTrue(driver.findElement(By.id("mCSB_1")).isDisplayed());
    }

    //16. Assert footer
    public void footerExistence() {
        assertTrue(driver.findElement(By.cssSelector(".footer-bg")).isDisplayed());
    }
}

