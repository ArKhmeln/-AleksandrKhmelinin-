package hw2.ex2;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Exercise2 extends Ex2Methods {

    @Test
    public void ex2EpamSiteTests() {
        goToWebsite("https://epam.github.io/JDI");
        // TODO I do not understand this step(
        browserTitle("Home Page");
        login("epam", "1234");
        // TODO I do not understand this step(
        username("PITER CHAILOVSKII");
        // TODO I do not understand this step(
        headerDropdown(Arrays.asList("SUPPORT", "DATES", "SEARCH", "COMPLEX TABLE",
                "SIMPLE TABLE", "USER TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE"));
        // TODO I do not understand this step(
        leftDropdown(Arrays.asList("Support", "Dates", "Complex Table",
                "Simple Table", "Search", "User Table", "Table with pages", "Different elements", "Performance"));
        // TODO I do not understand this step(
        serviceElementsclick();
        // TODO I do not understand this step(
        pageElements();
        // TODO I do not understand this step(
        rightSectionExistence();
        // TODO I do not understand this step(
        leftSectionExistence();
        selectCheckbox();
        // TODO I do not understand this step(
        checkboxLogo();
        // TODO I do not understand this step(
        radiobutton();
        // TODO I do not understand this step(
        radiobuttonLogo();
        dropdownSelect();
        // TODO I do not understand this step(
        dropdownLog();
        unselectCheckbox();
        // TODO I do not understand this step(
        checkboxUnselectLog();
    }
}
