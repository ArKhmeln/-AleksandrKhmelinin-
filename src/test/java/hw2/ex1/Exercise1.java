package hw2.ex1;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Exercise1 extends Ex1Methods {

    @Test
    public void ex1EpamSiteTests() {
        goToWebsite("https://epam.github.io/JDI");
        browserTitle("Home Page");
        login("epam", "1234");
        // TODO I do not understand this step(
        username("PITER CHAILOVSKII");
        assertHeadersection(Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));
        pageImagesExistence();
        // FIXME test failed here if run through the maven
        iconTextsDisplayed();
        // TODO I do not understand this step(
        mainHeaderText();
        // TODO I do not understand this step(
        inframeExistence();
        // TODO I do not understand this step(
        iframeEpamLogo();
        switchToOriginalWindow();
        // TODO I do not understand this step(
        subheaderText("JDI GITHUB");
        // TODO I do not understand this step(
        subheaderLink("https://github.com/epam/JDI");
        // TODO I do not understand this step(
        leftSectionExistence();
        // TODO I do not understand this step(
        footerExistence();
    }
}
