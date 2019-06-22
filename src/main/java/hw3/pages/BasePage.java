package hw3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public abstract class BasePage {

    protected WebDriver driver;

    public List<String> actualElements = new ArrayList<>();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToWebsite(String website) {
        driver.get(website);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    //Click(optional) and assert text
    public void checkText(WebElement elementToClick, List<WebElement> elementsList) {
        if (elementToClick != null) {
            elementToClick.click();
        }
        for (WebElement element : elementsList) {
            actualElements.add(element.getText());
        }
    }

    //Assert section presence
    protected void assertSectionPresence(WebElement element) {
        assertTrue(element.isDisplayed());
    }
}
