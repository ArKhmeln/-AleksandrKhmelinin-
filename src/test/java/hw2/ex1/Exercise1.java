package hw2.ex1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Exercise1 extends Ex1Methods {

    @Test
    public void ex1EpamWebsiteTests() {
        assertBrowserTitle("Home Page");
        assertUsername("PITER CHAILOVSKII");
        assertHeaderSectionText(Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));
        assertPageImagesPresence();
        assertIconText(expectedIconText);
        assertMainHeaderText(expectedMainHeaderText);
        assertIframePresence();
        assertIframeEpamLogo();
        switchToOriginalWindow();
        assertSubHeaderText("JDI GITHUB");
        assertSubHeaderLink("https://github.com/epam/JDI");
        assertSectionPresence(By.id("mCSB_1"));     //Left section
        assertSectionPresence(By.cssSelector(".footer-bg"));    //Footer
    }
}
