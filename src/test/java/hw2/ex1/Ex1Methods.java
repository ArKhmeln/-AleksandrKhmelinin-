package hw2.ex1;

import hw2.hw2Base.Hw2BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class Ex1Methods extends Hw2BaseTest {

    //6. Assert header section
    protected void assertHeaderSectionText(List<String> expectedElements) {
        checkTextEquality(By.cssSelector("ul[class$='navbar-nav m-l8']>li>a[href]," +
                " ul[class$='navbar-nav m-l8'] a.dropdown-toggle"), expectedElements);
    }

    //7. Assert index page images
    protected void assertPageImagesPresence() {
        List<WebElement> images = driver.findElements(By.
                cssSelector("div[class='row clerafix benefits'] .benefit-icon"));
        for(WebElement element : images) {
            assertTrue(element.isDisplayed());
        }
    }

    //8. Assert icon texts
    protected void assertIconText(List<String> expectedIconText) {
        checkTextEquality(By.cssSelector(".main-content .benefit-txt"), expectedIconText);
    }

    //9. Assert main header text
    protected void assertMainHeaderText(List<String> expectedMainHeaderText) {
        checkTextEquality(By.cssSelector("[class$='text-center']:nth-child(-n+2)"), expectedMainHeaderText);
    }

    protected void checkTextEquality(By textToCheck, List<String> expectedElements) {
        List<String> actualElements = getTextFromElements(textToCheck);
        assertEquals(actualElements, expectedElements);
    }

    //10. Assert inframe existence
    protected void assertIframePresence() {
        assertTrue(driver.findElement(By.id("iframe")).isDisplayed());
    }

    //11. Switch to the inframe, check EPAM logo
    protected void assertIframeEpamLogo() {
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.id("epam_logo")).isDisplayed());
    }

    //12. Switch to original window
    protected void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }

    //13. Assert sub header text
    protected void assertSubHeaderText(String expectedSubHeader) {
        assertEquals(driver.findElement(By.cssSelector(".text-center>a")).getText(), expectedSubHeader);
    }

    //14 Assert sub header link
    protected void assertSubHeaderLink(String expectedSubHeaderLink) {
        assertTrue(driver.findElement(By.linkText("JDI GITHUB")).isDisplayed());
        WebElement subHeader = driver.findElement(By.cssSelector(".text-center>a"));
        String actualSubHeaderLink = subHeader.getAttribute("href");
        assertEquals(actualSubHeaderLink, expectedSubHeaderLink);
    }
}

