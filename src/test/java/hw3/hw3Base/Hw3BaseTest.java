package hw3.hw3Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static org.testng.AssertJUnit.assertEquals;

public class Hw3BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    protected void setUpDriverPath() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        goToWebsite("https://epam.github.io/JDI");
        assertBrowserTitle("Home Page");
    }

    @AfterMethod
    protected void tearDown() {
        driver.close();
    }

    //Open test site
    protected void goToWebsite(String URL) {
        driver.get(URL);
    }

    //Assert browser title
    protected void assertBrowserTitle(String browserTitle) {
        assertEquals(driver.getTitle(), browserTitle);
    }

}

