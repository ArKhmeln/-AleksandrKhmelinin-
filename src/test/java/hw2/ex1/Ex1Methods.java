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
        // TODO Why this method does not return List<String>
        checkText(null, By.cssSelector("ul[class$='navbar-nav m-l8']>li>a[href]," +
                        " ul[class$='navbar-nav m-l8'] a.dropdown-toggle"));
        assertEquals(actualElements, expectedElements);
        // TODO Is clear required here?
        actualElements.clear();
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
        // TODO Why this method does not return List<String>
        checkText(null, By.cssSelector(".main-content .benefit-txt"));
        assertEquals(actualElements, expectedIconText);
        // TODO Is clear required here?
        actualElements.clear();
    }

    //9. Assert main header text
    protected void assertMainHeaderText(List<String> expectedMainHeaderText) {
        // TODO Why this method does not return List<String>
        checkText(null, By.cssSelector("[class$='text-center']:nth-child(-n+2)"));
        assertEquals(actualElements, expectedMainHeaderText);
        // TODO Is clear required here?
        actualElements.clear();
    }

    //10. Assert inframe existence
    protected void assertIframePresence() {
        // TODO Why this variable required?
        WebElement inframe = driver.findElement(By.id("iframe"));
        assertTrue(inframe.isDisplayed());
    }

    //11. Switch to the inframe, check EPAM logo
    protected void assertIframeEpamLogo() {
        driver.switchTo().frame("iframe");
        // TODO Why this variable required?
        WebElement iframeEPAMLogo = driver.findElement(By.id("epam_logo"));
        assertTrue(iframeEPAMLogo.isDisplayed());
    }

    //12. Switch to original window
    protected void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }

    //13. Assert sub header text
    protected void assertSubHeaderText(String expectedSubHeader) {
        // TODO Why this variable required?
        WebElement subHeader = driver.findElement(By.cssSelector(".text-center>a"));
        assertEquals(subHeader.getText(), expectedSubHeader);
    }

    //14 Assert sub header link
    protected void assertSubHeaderLink(String expectedSubHeaderLink) {
        assertTrue(driver.findElement(By.linkText("JDI GITHUB")).isDisplayed());
        WebElement subHeader = driver.findElement(By.cssSelector(".text-center>a"));
        String actualSubHeaderLink = subHeader.getAttribute("href");
        assertEquals(actualSubHeaderLink, expectedSubHeaderLink);
    }

}

