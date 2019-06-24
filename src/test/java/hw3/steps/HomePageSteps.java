package hw3.steps;

import hw3.enums.WebsiteInfo;
import hw3.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSteps extends BaseStep {

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

    public void assertUserNameTextField(WebsiteInfo name) {
        String actualName = homePage.getUserNameElement().getText();
        assertEquals(actualName, name.getText());
    }

    public void assertHeaderItemsText(List<String> expectedText) {
        List<String> actualElements = getTextFromElements(null, homePage.getHeaderSectionItems());
        assertEquals(actualElements, expectedText);
    }

    public void assertPageImagesPresence() {
        List<WebElement> images = homePage.getPageImages();
        for(WebElement element: images) {
            assertTrue(element.isDisplayed());
        }
    }

    public void assertPageIconsText(List<String> expectedText) {
        List<String> actualElements = getTextFromElements(null, homePage.getPageIconText());
        assertEquals(actualElements, expectedText);
    }

    public void assertMainHeaderText(List<String> expectedText) {
        List<String> actualElements = getTextFromElements(null, homePage.getMainHeaderText());
        assertEquals(actualElements, expectedText);
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

    public void assertSubHeaderText(WebsiteInfo text) {
        String subHeader = homePage.getSubHeaderText().getText();
        assertEquals(subHeader, text.getText());
    }

    public void assertSubHeaderLink(WebsiteInfo expectedSubHeaderLink) {
        assertTrue(homePage.getSubHeaderLinkText().isDisplayed());
        String subHeaderLink = homePage.getSubHeaderLink().getAttribute("href");
        assertEquals(subHeaderLink, expectedSubHeaderLink.getText());
    }

    public void assertLeftSectionPresence() {
        assertSectionPresence(homePage.getLeftSection());
    }

    public void assertFooterPresence() {
        assertSectionPresence(homePage.getFooter());
    }

    //Steps for Exercise2 start here
    public void assertHeaderDropdownTextInService(List<String> expectedHeaderDropdown) {
        List<String> actualElements = getTextFromElements(homePage.getHeaderDropdownInService(), homePage.getHeaderDropdownTextInService());
        assertEquals(actualElements, expectedHeaderDropdown);
    }

    public void assertLeftSectionDropdownTextInService(List<String> expectedLeftDropdown) {
        List<String> actualElements = getTextFromElements(homePage.getLeftSectionServiceDropdown(), homePage.getLeftSectionServiceDropdownText());
        assertEquals(actualElements, expectedLeftDropdown);
    }

    public void goToServiceDifferentElementsInHeader() {
        homePage.getLeftSectionService().click();
        homePage.getLeftSectionServiceDifferentElements().click();
    }
}
