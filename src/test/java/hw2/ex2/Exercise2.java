package hw2.ex2;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertTrue;

public class Exercise2 extends Ex2Methods {

    @Test
    public void ex2EpamSiteTests() {
        goToWebsite("https://epam.github.io/JDI");
        // TODO I do not understand this step(      -fixed
        assertBrowserTitle("Home Page");
        login("epam", "1234");
        // TODO I do not understand this step(      -fixed
        assertUsername("PITER CHAILOVSKII");
        // TODO I do not understand this step(      -fixed
        assertHeaderDropdownText(Arrays.asList("SUPPORT", "DATES", "SEARCH", "COMPLEX TABLE",
                "SIMPLE TABLE", "USER TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE"));
        // TODO I do not understand this step(      -fixed
        assertLeftDropdownText(Arrays.asList("Support", "Dates", "Complex Table",
                "Simple Table", "Search", "User Table", "Table with pages", "Different elements", "Performance"));
        // TODO I do not understand this step(
        serviceElementsClick();
        // TODO I do not understand this step(
        pageElements();
        // TODO I do not understand this step(
        rightSectionExistence();
        // TODO I do not understand this step(
        assertLeftSectionPresence("mCSB_1_container");
        selectCheckbox("Water","Wind");
        // TODO I do not understand this step(      -fixed
        assertTrue(checkLogoText("Water: condition changed to true"));
        assertTrue(checkLogoText("Wind: condition changed to true"));
        // TODO I do not understand this step(
        selectRadiobutton("Selen");
        // TODO I do not understand this step(
        radiobuttonLogo("metal: value changed to  Selen");
        dropdownSelect(4);
        // TODO I do not understand this step(
        dropdownLog("Colors: value changed to Yellow");
        selectCheckbox("Water","Wind");
        // TODO I do not understand this step(
        checkboxUnselectLog("Water: condition changed to false", "Wind: condition changed to false");
    }
}
