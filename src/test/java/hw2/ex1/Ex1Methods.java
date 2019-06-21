package hw2.ex1;

import hw2.hw2Base.Hw2BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class Ex1Methods extends Hw2BaseTest {

    // TODO Please follow java code convention for the method naming    -fixed
    //6. Assert header section
    // TODO What type of elements could contain list?   -fixed
    protected void assertHeaderSectionText(List<String> expectedElements) {
        checkText(null, By.cssSelector("ul[class$='navbar-nav m-l8']>li>a[href]," +
                        " ul[class$='navbar-nav m-l8'] a.dropdown-toggle"));
        // TODO looks like crutch   -fixed
        // TODO For collections could be used another assert    -skype
        assertEquals(actualElements, expectedElements);
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
        List<WebElement> iconTexts = driver.findElements(By.cssSelector(".main-content .benefit-txt"));
        List<String> actualIconText = new ArrayList<>();
        for(WebElement element : iconTexts) {
            actualIconText.add(element.getText());
            assertTrue(element.isDisplayed());
        }
        // TODO COuld this text moved to the parameters of the method? Why?     -fixed
        // TODO For collections could be used another assert    -skype
        assertEquals(actualIconText, expectedIconText);
    }

    //9. Assert main header text
    protected void assertMainHeaderText(List<String> expectedMainHeaderText) {
        List<WebElement> mainHeaderText = driver.findElements(By.cssSelector("[class$='text-center']:nth-child(-n+2)"));
        List<String> actualMainHeaderText = new ArrayList<>();
        for(WebElement element : mainHeaderText) {
            actualMainHeaderText.add(element.getText());
        }
        // TODO COuld this text moved to the parameters of the method? Why?     -fixed
        // TODO For collections could be used another assert    -skype
        assertEquals(actualMainHeaderText, expectedMainHeaderText);
    }

    //10. Assert inframe existence
    protected void assertIframePresence() {
        WebElement inframe = driver.findElement(By.id("iframe"));
        assertTrue(inframe.isDisplayed());
    }

    //11. Switch to the inframe, check EPAM logo
    protected void assertIframeEpamLogo() {
        driver.switchTo().frame("iframe");
        WebElement iframeEPAMLogo = driver.findElement(By.id("epam_logo"));
        assertTrue(iframeEPAMLogo.isDisplayed());
    }

    //12. Switch to original window
    protected void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }

    // TODO Please follow java code convention for the method naming    -fixed
    //13. Assert sub header text
    protected void assertSubHeaderText(String expectedSubHeader) {
        WebElement subHeader = driver.findElement(By.cssSelector(".text-center>a"));
        assertEquals(subHeader.getText(), expectedSubHeader);
    }

    // TODO Please follow java code convention for the method naming    -fixed
    //14 Assert sub header link
    protected void assertSubHeaderLink(String expectedSubHeaderLink) {
        assertTrue(driver.findElement(By.linkText("JDI GITHUB")).isDisplayed());
        WebElement subHeader = driver.findElement(By.cssSelector(".text-center>a"));
        String actualSubHeaderLink = subHeader.getAttribute("href");
        assertEquals(actualSubHeaderLink, expectedSubHeaderLink);
    }

}

