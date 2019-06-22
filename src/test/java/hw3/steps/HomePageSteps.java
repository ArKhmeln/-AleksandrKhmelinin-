package hw3.steps;

import hw3.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSteps {

    private WebDriver driver;

    private HomePage homePage;

    public HomePageSteps(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
    }

    public void login(String userName, String password) {
        homePage.clickUserIcon();
        homePage.fillInLoginNameTextField(userName);
        homePage.enterPassword(password);
        homePage.clickLoginButton();
    }

    public void assertUserNameTextField(String name) {
        String actualName = homePage.getUserNameElement().getText();
        assertEquals(actualName, "PITER CHAILOVSKII");
    }

    public void assertHeaderItemsText(List<String> expectedText) {
        homePage.checkText(null, homePage.getHeaderSectionItems());
        assertEquals(homePage.actualElements, expectedText);
        homePage.actualElements.clear();
    }

    public void assertPageImagesPresence() {
        List<WebElement> images = homePage.getPageImages();
        for(WebElement element: images) {
            assertTrue(element.isDisplayed());
        }
    }

    public void assertPageIconsText(List<String> expectedText) {
        homePage.checkText(null, homePage.getPageIconText());
        assertEquals(homePage.actualElements, expectedText);
        homePage.actualElements.clear();
    }

    public void assertMainHeaderText(List<String> expectedText) {
        homePage.checkText(null, homePage.getMainHeaderText());
        assertEquals(homePage.actualElements, expectedText);
        homePage.actualElements.clear();
    }

    public void  assertIframePresence() {
        WebElement iframe = homePage.getIframe();
        assertTrue(iframe.isDisplayed());
    }

    public void assertEpamLogoInIframe() {
        driver.switchTo().frame(homePage.getIframe());
        WebElement iframeEPAMLogo = homePage.getEpamLogo();
        assertTrue(iframeEPAMLogo.isDisplayed());
        driver.switchTo().defaultContent();
    }

    public void assertSubHeaderText(String text) {
        String subHeader = homePage.getSubHeaderText().getText();
        assertEquals(subHeader, text);
    }

    public void assertSubHeaderLink(String expectedSubHeaderLink) {
        assertTrue(homePage.getSubHeaderLinkText().isDisplayed());
        String subHeaderLink = homePage.getSubHeaderLink().getAttribute("href");
        assertEquals(subHeaderLink, expectedSubHeaderLink);
    }

    public void assertLeftSectionPresence() {
        assertTrue(homePage.getLeftSection().isDisplayed());
    }

    public void assertRightSectionPresence() {
        assertTrue(homePage.getRightSection().isDisplayed());
    }

    //Steps for the Exercise2 start there
    public void assertHeaderDropdownTextInService(List<String> expectedHeaderDropdown) {
        homePage.checkText(homePage.getHeaderDropdownInService(), homePage.getHeaderDropdownTextInService());
        assertEquals(homePage.actualElements, expectedHeaderDropdown);
        homePage.actualElements.clear();
    }

    public void assertLeftSectionDropdownTextInService(List<String> expectedLeftDropdown) {
        homePage.checkText(homePage.getLeftSectionServiceDropdown(), homePage.getLeftSectionServiceDropdownText());
        assertEquals(homePage.actualElements, expectedLeftDropdown);
        homePage.actualElements.clear();
    }

    public void goToServiceDifferentElementsInHeader() {
        homePage.getLeftSectionService().click();
        homePage.getLeftSectionServiceDifferentElements().click();
    }
}
