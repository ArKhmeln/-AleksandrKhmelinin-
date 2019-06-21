package hw2.ex2;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertTrue;

public class Exercise2 extends Ex2Methods {

    @Test
    public void ex2EpamSiteTests() {
        // TODO I do not understand this step(      -fixed
        assertBrowserTitle("Home Page");
        // TODO I do not understand this step(      -fixed
        assertUsername("PITER CHAILOVSKII");
        // TODO I do not understand this step(      -fixed
        assertHeaderDropdownTextInService(Arrays.asList("SUPPORT", "DATES", "SEARCH", "COMPLEX TABLE",
                "SIMPLE TABLE", "USER TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE"));
        // TODO I do not understand this step(      -fixed
        assertLeftDropdownTextInService(Arrays.asList("Support", "Dates", "Complex Table",
                "Simple Table", "Search", "User Table", "Table with pages", "Different elements", "Performance"));
        // TODO I do not understand this step(      -fixed
        goToServiceDifferentElementsInHeader();
        // TODO I do not understand this step(      -fixed
        assertPageElementsPresence();
        // TODO I do not understand this step(      -fixed
        assertRightSectionPresence();
        // TODO I do not understand this step(      -fixed
        assertLeftSectionPresence("mCSB_1_container");
        selectCheckbox("Water");
        selectCheckbox("Wind");
        // TODO I do not understand this step(      -fixed
        assertTrue(checkLogoText("Water: condition changed to true"));
        assertTrue(checkLogoText("Wind: condition changed to true"));
        // TODO I do not understand this step(      -fixed
        selectRadiobutton("Selen");
        // TODO I do not understand this step(      -fixed
        assertTrue(checkLogoText("metal: value changed to Selen"));
        dropdownSelect("Yellow");
        // TODO I do not understand this step(      -fixed
        assertTrue(checkLogoText("Colors: value changed to Yellow"));
        selectCheckbox("Water");
        selectCheckbox("Wind");
        // TODO I do not understand this step(      -fixed
        assertTrue(checkLogoText("Water: condition changed to false"));
        assertTrue(checkLogoText("Wind: condition changed to false"));
    }
}
