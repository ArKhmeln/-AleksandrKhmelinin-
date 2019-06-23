package hw3.steps;

import hw3.enums.DifferentElements;
import hw3.enums.LogTexts;
import hw3.pages.DifferentElementsPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPageSteps {

    private WebDriver driver;

    private DifferentElementsPage differentElementsPage;

    public DifferentElementsPageSteps(WebDriver driver) {
        this.driver = driver;
        differentElementsPage = new DifferentElementsPage(driver);
    }

    public void assertPageElementsPresence() {
        int checkboxes = differentElementsPage.getCheckboxes().size();
        assertEquals(checkboxes, 4);
        int radiobuttons = differentElementsPage.getRadiobuttons().size();
        assertEquals(radiobuttons, 4);
        int dropdownMenu = differentElementsPage.getDropdown().size();
        assertEquals(dropdownMenu, 1);
        int buttons = differentElementsPage.getButtons().size();
        assertEquals(buttons, 2);
    }

    public void assertLeftSectionPresence() {
        assertTrue(differentElementsPage.getLeftSection().isDisplayed());
    }

    public void assertRightSectionPresence() {
        assertTrue(differentElementsPage.getRightSection().isDisplayed());
    }

    public void selectAndClickCheckbox(DifferentElements ... checkboxes) {
        for(DifferentElements name: checkboxes) {
            differentElementsPage.selectAndClickElementByName(differentElementsPage.getCheckboxes(), name);
        }
    }

    public void assertLogByText(LogTexts ... expectedLogs) {
        for(LogTexts text: expectedLogs) {
            assertTrue(differentElementsPage.checkLogoText(differentElementsPage.getLogs(), text));
        }
    }

    public void selectAndClickRadiobutton(DifferentElements name) {
        differentElementsPage.selectAndClickElementByName(differentElementsPage.getRadiobuttons(), name);
    }

    public void selectAndClickDropdown(DifferentElements name) {
        differentElementsPage.getDropdownMenu().click();
        differentElementsPage.selectAndClickElementByName(differentElementsPage.getDropdownMenuElements(), name);
    }


}
