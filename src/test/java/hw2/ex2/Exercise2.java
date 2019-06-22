package hw2.ex2;

import org.openqa.selenium.By;
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
        assertSectionPresence(By.cssSelector("[class~='right-fix-panel']"));   //right section
        // TODO I do not understand this step(      -fixed
        assertSectionPresence(By.id("mCSB_1_container"));   //left section
        selectAndClickElementByName(By.className("label-checkbox"), "Water");   //checkbox
        selectAndClickElementByName(By.className("label-checkbox"), "Wind");    //checkbox
        // TODO I do not understand this step(      -fixed
        assertTrue(logoTextIsValid("Water: condition changed to true"));
        assertTrue(logoTextIsValid("Wind: condition changed to true"));
        // TODO I do not understand this step(      -fixed
        selectAndClickElementByName(By.className("label-radio"), "Selen");      //radiobutton
        // TODO I do not understand this step(      -fixed
        assertTrue(logoTextIsValid("metal: value changed to Selen"));
        dropdownSelect("Yellow");
        // TODO I do not understand this step(      -fixed
        assertTrue(logoTextIsValid("Colors: value changed to Yellow"));
        selectAndClickElementByName(By.className("label-checkbox"), "Water");   //checkbox
        selectAndClickElementByName(By.className("label-checkbox"), "Wind");    //checkbox
        // TODO I do not understand this step(      -fixed
        assertTrue(logoTextIsValid("Water: condition changed to false"));
        assertTrue(logoTextIsValid("Wind: condition changed to false"));
    }
}
