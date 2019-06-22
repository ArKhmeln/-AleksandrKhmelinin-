package hw3.ex1;

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
    public void ex1EpamSiteTests() {
        homePageSteps.login("epam", "1234");    //to properties
        homePageSteps.assertUserNameTextField("PITER CHAILOVSKII");     //to properties
        homePageSteps.assertHeaderItemsText(headerMenuItems());
        homePageSteps.assertPageImagesPresence();
        homePageSteps.assertPageIconsText(pageIconsText());
        homePageSteps.assertMainHeaderText(mainHeaderText());
        homePageSteps.assertIframePresence();
        homePageSteps.assertEpamLogoInIframe();
        homePageSteps.assertSubHeaderText(JDI_GITHUB.getText());
        homePageSteps.assertSubHeaderLink(LINK.getText());
        homePageSteps.assertLeftSectionPresence();
        homePageSteps.assertRightSectionPresence();
    }
}
