package hw2.ex1;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Exercise1 extends Ex1Methods {

    @Test
    public void ex1EpamSiteTests() {
        goToWebsite("https://epam.github.io/JDI");
        browserTitle("Home Page");
        login("epam", "1234");
        username("PITER CHAILOVSKII");
        assertHeadersection(Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));
        pageImagesExistence();
        iconTextsDisplayed();
        mainHeaderText();
        inframeExistence();
        iframeEpamLogo();
        switchToOriginalWindow();
        subheaderText("JDI GITHUB");
        subheaderLink("https://github.com/epam/JDI");
        leftSectionExistence();
        footerExistence();
    }
}
