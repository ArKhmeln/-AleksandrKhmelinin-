package hw2.ex2;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Exercise2 extends Ex2Methods {

    @Test
    public void ex2EpamSiteTests() {
        goToWebsite("https://epam.github.io/JDI");
        browserTitle("Home Page");
        login("epam", "1234");
        username("PITER CHAILOVSKII");
        headerDropdown(Arrays.asList("SUPPORT", "DATES", "SEARCH", "COMPLEX TABLE",
                "SIMPLE TABLE", "USER TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE"));
        leftDropdown(Arrays.asList("Support", "Dates", "Complex Table",
                "Simple Table", "Search", "User Table", "Table with pages", "Different elements", "Performance"));
        serviceElementsclick();
        pageElements();
        rightSectionExistence();
        leftSectionExistence();
        selectCheckbox();
        checkboxLogo();
        radiobutton();
        radiobuttonLogo();
        dropdownSelect();
        dropdownLog();
        unselectCheckbox();
        checkboxUnselectLog();
    }
}
