package hw2.hw2Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

// TODO Unused import    -fixed

public class Hw2BaseTest {

    protected WebDriver driver;

    protected List<String> actualElements = new ArrayList<>();

    protected List<String> expectedIconText = Arrays.asList("To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM project", "To be flexible and\n" +
            "customizable", "To be multiplatform", "Already have good base\n" +
            "(about 20 internal and\n" +
            "some external projects),\n" +
            "wish to get more…");

    protected List<String> expectedMainHeaderText = Arrays.asList("EPAM FRAMEWORK WISHES…", "LOREM IPSUM DOLOR SIT AMET," +
            " CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT" +
            " ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO" +
            " CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT" +
            " NULLA PARIATUR.");

    @BeforeSuite
    protected void setUpDriverPath() {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getClassLoader().getResource("files/chromedriver.exe").getPath());
    }

    @BeforeMethod
    protected void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        goToWebsite("https://epam.github.io/JDI");
        login("epam", "1234");
    }

    @AfterMethod
    protected void tearDown() {
        driver.close();
    }

        //Some common methods

    //Open test site
    protected void goToWebsite(String URL) {
        driver.get(URL);
    }

    //Perform login
    protected void login(String login, String password) {
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    //Assert browser title
    protected void assertBrowserTitle(String browserTitle) {
        assertEquals(driver.getTitle(), browserTitle);
    }

    //Assert user name
    protected void assertUsername(String expectedUsername) {
        WebElement actualUsername = driver.findElement(By.id("user-name"));
        // TODO It is better check visibility and after that text :)    -fixed
        assertTrue(actualUsername.isDisplayed());
        assertEquals(actualUsername.getText(), expectedUsername);
    }

    //15. Assert left section
    protected void assertSectionPresence(By locator) {
        Assert.assertTrue(driver.findElement(locator).isDisplayed());
    }

    //Click(optional) and assert text
    protected void checkText(By clickSelector, By elementsSelector) {
        if (clickSelector != null) {
            driver.findElement(clickSelector).click();
        }
        List<WebElement> headerDropdown = driver.findElements(elementsSelector);
        for(WebElement element: headerDropdown) {
            actualElements.add(element.getText());
        }
    }

    //11, 15, 17 Select/unselect checkboxes, radiobutton, dropdown
    protected void selectAndClickElement(By elements, String name) {
        List<WebElement> buttons = driver.findElements(elements);
        for(WebElement element: buttons) {
            if (element.getText().equals(name)) {
                element.click();
            }
        }
    }

    //12,14,16,18 Checkboxes logo rows
    protected boolean checkLogoText(String searchingText) {
        List<WebElement> logoElements = driver.findElements(By.xpath("//ul[@class='panel-body-list logs']/li"));
        for (WebElement element : logoElements) {
            if (element.getText().endsWith(searchingText)) {
                return true;
            }
        }
        return false;
    }
}

