package hw3.ex2;

import hw3.hw3Base.Hw3BaseTest;
import hw3.steps.DifferentElementsPageSteps;
import hw3.steps.HomePageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static hw3.enums.DifferentElements.*;
import static hw3.enums.HeaderServiceDropdown.headerServiceDropdownText;
import static hw3.enums.LeftSectionServiceDropdown.leftSectionServiceDropdownText;
import static hw3.enums.LogTexts.*;

public class Exercise2 extends Hw3BaseTest {

    HomePageSteps homePageSteps;
    DifferentElementsPageSteps differentElementsPageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
        differentElementsPageSteps = new DifferentElementsPageSteps(driver);
    }

    @Test
    public void ex2EpamSiteTests() {
        homePageSteps.login("epam", "1234");
        homePageSteps.assertUserNameTextField("PITER CHAILOVSKII");
        homePageSteps.assertHeaderDropdownTextInService(headerServiceDropdownText());
        homePageSteps.assertLeftSectionDropdownTextInService(leftSectionServiceDropdownText());
        homePageSteps.goToServiceDifferentElementsInHeader();
        differentElementsPageSteps.assertPageElementsPresence();
        differentElementsPageSteps.assertRightSectionPresence();
        differentElementsPageSteps.assertLeftSectionPresence();
        differentElementsPageSteps.selectAndClickCheckbox(WATER);
        differentElementsPageSteps.selectAndClickCheckbox(WIND);
        differentElementsPageSteps.assertLogByText(WATER_TRUE);
        differentElementsPageSteps.assertLogByText(WIND_TRUE);
        differentElementsPageSteps.selectAndClickRadiobutton(SELEN);
        differentElementsPageSteps.assertLogByText(METAL_SELEN);
        differentElementsPageSteps.selectAndClickDropdown(YELLOW);
        differentElementsPageSteps.assertLogByText(COLORS_YELLOW);
        differentElementsPageSteps.selectAndClickCheckbox(WATER);
        differentElementsPageSteps.selectAndClickCheckbox(WIND);
        differentElementsPageSteps.assertLogByText(WATER_FALSE);
        differentElementsPageSteps.assertLogByText(WIND_FALSE);
    }
}
