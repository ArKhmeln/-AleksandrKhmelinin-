package hw3.steps;

import hw3.enums.WebsiteInfo;
import hw3.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSteps extends BaseStep {

    // TODO Why do you not extract this field to the base class?
    private WebDriver driver;

    private HomePage homePage;

    public HomePageSteps(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
    }

    public void login(String userName, String password) {
        homePage.clickUserIcon();
        // TODO It is better use one template for the page method
        // TODO ex. clickNameButton, fillTextFieldNameTextField, selectCheckbox and etc.
        homePage.fillInLoginNameTextField(userName);
        homePage.enterPassword(password);
        homePage.clickLoginButton();
    }

    public void assertUserNameTextField(WebsiteInfo name) {
        // TODO this variable is redundant
        String actualName = homePage.getUserNameElement().getText();
        assertEquals(actualName, name.getText());
    }

    public void assertHeaderItemsText(List<String> expectedText) {
        checkTextEquality(homePage.getHeaderSectionItems(), expectedText);
    }

    public void assertPageImagesPresence() {
        List<WebElement> images = homePage.getPageImages();
        for(WebElement element: images) {
            assertTrue(element.isDisplayed());
        }
    }

    public void assertPageIconsText(List<String> expectedText) {
        // TODO this variable is redundant
        List<String> actualElements = getTextFromElements(homePage.getPageIconText());
        assertEquals(actualElements, expectedText);
    }

    public void assertMainHeaderText(List<String> expectedText) {
        // TODO this variable is redundant
        List<String> actualElements = getTextFromElements(homePage.getMainHeaderText());
        assertEquals(actualElements, expectedText);
    }

    public void  assertIframePresence() {
        // TODO this variable is redundant
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
        // TODO this variable is redundant
        String subHeader = homePage.getSubHeaderText().getText();
        assertEquals(subHeader, text.getText());
    }

    public void assertSubHeaderLink(WebsiteInfo expectedSubHeaderLink) {
        assertTrue(homePage.getSubHeaderLinkText().isDisplayed());
        // TODO this variable is redundant
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
        clickAndCheckTextEquality(homePage.getHeaderDropdownInService(), homePage.getHeaderDropdownTextInService(),
                expectedHeaderDropdown);
    }

    public void assertLeftSectionDropdownTextInService(List<String> expectedLeftDropdown) {
        clickAndCheckTextEquality(homePage.getLeftSectionServiceDropdown(),
                homePage.getLeftSectionServiceDropdownText(), expectedLeftDropdown);
    }

    public void goToServiceDifferentElementsInHeader() {
        homePage.getLeftSectionService().click();
        homePage.getLeftSectionServiceDifferentElements().click();
    }
}
