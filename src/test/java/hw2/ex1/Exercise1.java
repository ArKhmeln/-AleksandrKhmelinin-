package hw2.ex1;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Exercise1 extends Ex1Methods {

    @Test
    public void ex1EpamSiteTests() {
        assertBrowserTitle("Home Page");
        // TODO I do not understand this step(      -fixed
        assertUsername("PITER CHAILOVSKII");
        assertHeaderSection(Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));
        assertPageImagesPresence();
        // FIXME test failed here if run through the maven      -skype
        assertIconText(expectedIconText);
        // TODO I do not understand this step(      -fixed
        assertMainHeaderText(expectedMainHeaderText);
        // TODO I do not understand this step(      -fixed
        assertIframePresence();
        // TODO I do not understand this step(      -fixed
        assertIframeEpamLogo();
        switchToOriginalWindow();
        // TODO I do not understand this step(      -fixed
        assertSubHeaderText("JDI GITHUB");
        // TODO I do not understand this step(      -fixed
        assertSubHeaderLink("https://github.com/epam/JDI");
        // TODO I do not understand this step(      -fixed
        assertLeftSectionPresence("mCSB_1");
        // TODO I do not understand this step(      -fixed
        assertFooterPresence();
    }
}
