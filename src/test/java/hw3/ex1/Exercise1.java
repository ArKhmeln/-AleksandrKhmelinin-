package hw3.ex1;

import hw3.enums.Additional;
import hw3.hw3Base.Hw3BaseTest;
import hw3.steps.HomePageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static hw3.enums.Additional.*;
import static hw3.enums.HeaderMenu.headerMenuItems;
import static hw3.enums.MainHeader.mainHeaderText;
import static hw3.enums.PageIcons.pageIconsText;

public class Exercise1 extends Hw3BaseTest {

    HomePageSteps homePageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
    }

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
        homePageSteps.assertSubHeaderLink(LINK);
        //15. Assert that there is Left Section
        homePageSteps.assertLeftSectionPresence();
        //16. Assert that there is Footer
        homePageSteps.assertRightSectionPresence();
    }
}
