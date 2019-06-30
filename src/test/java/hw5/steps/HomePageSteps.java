package hw5.steps;

import hw5.enums.WebsiteInfo;
import hw5.ex1.TestProvider;
import hw5.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSteps extends BaseStep {

    private HomePage homePage;

    public HomePageSteps(WebDriver driver) {
        super.driver = driver;
        TestProvider.getInstance().setDriver(driver);
        homePage = new HomePage(driver);
    }

    @Step("Login as user: '{0}'")
    public void login(String userName, String password) {
        homePage.clickUserIcon();
        homePage.fillTextFieldName(userName);
        homePage.enterPassword(password);
        homePage.clickLoginButton();
    }

    @Step("Assert User name in the left-top side of screen that user is loggined")
    public void assertUserNameTextField(WebsiteInfo name) {
        assertEquals(homePage.getUserNameElement().getText(), name.getText());
    }

    @Step("Assert that there are 4 items on the header section are displayed and they have proper texts")
    public void assertHeaderItemsText(List<String> expectedText) {
        checkTextEquality(homePage.getHeaderSectionItems(), expectedText);
    }

    @Step("Assert that there are 4 images on the Index Page and they are displayed")
    public void assertPageImagesPresence() {
        List<WebElement> images = homePage.getPageImages();
        for(WebElement element: images) {
            assertTrue(element.isDisplayed());
        }
    }

    @Step("Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void assertPageIconsText(List<String> expectedText) {
        assertEquals(getTextFromElements(homePage.getPageIconText()), expectedText);
    }

    @Step("Assert a text of the main headers")
    public void assertMainHeaderText(List<String> expectedText) {
        assertEquals(getTextFromElements(homePage.getMainHeaderText()), expectedText);
    }

    @Step("Assert that there is the iframe in the center of page")
    public void  assertIframePresence() {
        assertTrue(homePage.getIframe().isDisplayed());
    }

    @Step("Switch to the iframe and check Epam logo in the left top conner, then switch back to original window")
    public void assertEpamLogoInIframe() {
        driver.switchTo().frame(homePage.getIframe());
        WebElement iframeEPAMLogo = homePage.getEpamLogo();
        assertTrue(iframeEPAMLogo.isDisplayed());
        driver.switchTo().defaultContent();
    }

    @Step("Assert a text of the sub header")
    public void assertSubHeaderText(WebsiteInfo text) {
        assertEquals(homePage.getSubHeaderText().getText(), text.getText());
    }

    @Step("Assert that JDI GITHUB is a link and has a proper URL")
    public void assertSubHeaderLink(WebsiteInfo expectedSubHeaderLink) {
        assertTrue(homePage.getSubHeaderLinkText().isDisplayed());
        assertEquals(homePage.getSubHeaderLink().getAttribute("href"), expectedSubHeaderLink.getText());
    }

    @Step("Assert that there is Left Section")
    public void assertLeftSectionPresence() {
        assertSectionPresence(homePage.getLeftSection());
    }

    @Step("Assert that there is Footer")
    public void assertFooterPresence() {
        assertSectionPresence(homePage.getFooter());
    }
}
