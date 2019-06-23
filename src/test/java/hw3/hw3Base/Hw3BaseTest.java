package hw3.hw3Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static org.testng.AssertJUnit.assertEquals;

public class Hw3BaseTest {

    protected WebDriver driver;

    private FileInputStream fis;

    private Properties property = new Properties();

    protected String login;

    protected String password;

    @BeforeSuite
    protected void setUpDriverPath() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        goToWebsite("https://epam.github.io/JDI");
        userData();
        assertBrowserTitle("Home Page");
    }

    @AfterMethod
    protected void tearDown() {
        driver.close();
    }


    //Perform login
    protected void userData() {
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
        } catch (IOException e) {
            System.err.println("ERROR: Property file not found!");
        }
        login = property.getProperty("login");
        password = property.getProperty("password");
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

