package hw3.steps;

import hw3.enums.DifferentElements;
import hw3.enums.LogTexts;
import hw3.pages.DifferentElementsPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPageSteps extends BaseStep {

    // TODO Why do you not extract this field to the base class?
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
        assertSectionPresence(differentElementsPage.getLeftSection());
    }

    public void assertRightSectionPresence() {
        assertSectionPresence(differentElementsPage.getRightSection());
    }

    public void selectAndClickCheckbox(DifferentElements ... checkboxes) {
        for(DifferentElements name: checkboxes) {
            selectAndClickElementByName("checkbox", name.getName());
        }
    }

    public void assertLogByText(LogTexts ... expectedLogs) {
        for(LogTexts text: expectedLogs) {
            assertTrue(checkLogoText(differentElementsPage.getLogs(), text));
        }
    }

    public void selectAndClickRadiobutton(DifferentElements name) {
        selectAndClickElementByName("radiobutton", name.getName());
    }

    public void selectAndClickDropdown(DifferentElements name) {
        differentElementsPage.getDropdownMenu().click();
        selectAndClickElementByName("dropdown", name.getName());
    }

    //11, 15, 17 Select/unselect checkboxes, radiobutton, dropdown
    protected void selectAndClickElementByName(String buttonName, String elementName) {
        switch (buttonName) {
            case "checkbox":
                findElementByName(differentElementsPage.getCheckboxes(), elementName);
                break;
            case "radiobutton":
                findElementByName(differentElementsPage.getRadiobuttons(), elementName);
                break;
            case "dropdown":
                findElementByName(differentElementsPage.getDropdownMenuElements(), elementName);
                break;
        }
    }
}
