package hw2.ex2;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertTrue;

public class Exercise2 extends Ex2Methods {

    @Test
    public void ex2EpamWebsiteTests() {
        assertBrowserTitle("Home Page");
        assertUsername("PITER CHAILOVSKII");
        assertHeaderDropdownTextInService(Arrays.asList("SUPPORT", "DATES", "SEARCH", "COMPLEX TABLE",
                "SIMPLE TABLE", "USER TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE"));
        assertLeftDropdownTextInService(Arrays.asList("Support", "Dates", "Complex Table",
                "Simple Table", "Search", "User Table", "Table with pages", "Different elements", "Performance"));
        goToServiceDifferentElementsInHeader();
        assertPageElementsPresence();
        assertSectionPresence(By.cssSelector("[class~='right-fix-panel']"));   //right section
        assertSectionPresence(By.id("mCSB_1_container"));   //left section
        selectAndClickElementByName(By.className("label-checkbox"), "Water");   //checkbox
        selectAndClickElementByName(By.className("label-checkbox"), "Wind");    //checkbox
        // TODO Is it possible use name of the checkboxes, radiobuttons and etc. as parameters
        assertTrue(logoTextIsValid("Water: condition changed to true"));
        assertTrue(logoTextIsValid("Wind: condition changed to true"));
        selectAndClickElementByName(By.className("label-radio"), "Selen");      //radiobutton
        assertTrue(logoTextIsValid("metal: value changed to Selen"));
        dropdownSelect("Yellow");
        assertTrue(logoTextIsValid("Colors: value changed to Yellow"));
        selectAndClickElementByName(By.className("label-checkbox"), "Water");   //checkbox
        selectAndClickElementByName(By.className("label-checkbox"), "Wind");    //checkbox
        assertTrue(logoTextIsValid("Water: condition changed to false"));
        assertTrue(logoTextIsValid("Wind: condition changed to false"));
    }
}
