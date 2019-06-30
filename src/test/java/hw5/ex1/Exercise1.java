package hw5.ex1;

import hw5.steps.HomePageSteps;
import hw5.hw5Base.Hw5BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static hw5.enums.HeaderMenu.headerMenuItems;
import static hw5.enums.MainHeader.mainHeaderText;
import static hw5.enums.PageIcons.pageIconsText;
import static hw5.enums.WebsiteInfo.*;

@Listeners(AllureAttachmentListener.class)
public class Exercise1 extends Hw5BaseTest {

    HomePageSteps homePageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
    }

    @Feature(value = "epam's WebSite testing")
    @Story(value = "Home Page testing")
    @Test
    public void ex1EpamWebsiteTests() {
        //3. Perform login
        homePageSteps.login(login, password);
        //4. Assert User name in the left-top side of screen that user is loggined
        homePageSteps.assertUserNameTextField(USER_NAME);
        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        homePageSteps.assertHeaderItemsText(headerMenuItems());
        //7. Assert that there are 4 images on the Index Page and they are displayed
        homePageSteps.assertPageImagesPresence();
        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePageSteps.assertPageIconsText(pageIconsText());
        //9. Assert a text of the main headers
        homePageSteps.assertMainHeaderText(mainHeaderText());
        //10. Assert that there is the iframe in the center of page
        homePageSteps.assertIframePresence();
        //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        //12. Switch to original window back
        homePageSteps.assertEpamLogoInIframe();
        //13. Assert a text of the sub header
        homePageSteps.assertSubHeaderText(JDI_GITHUB);
        //14. Assert that JDI GITHUB is a link and has a proper URL
        homePageSteps.assertSubHeaderLink(LINK_JDI);
        //15. Assert that there is Left Section
        homePageSteps.assertLeftSectionPresence();
        //16. Assert that there is Footer
        homePageSteps.assertFooterPresence();
    }
}
