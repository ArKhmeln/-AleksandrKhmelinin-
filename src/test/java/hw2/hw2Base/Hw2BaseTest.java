package hw2.hw2Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// TODO Unused import
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Hw2BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    protected void setUpDriverPath() {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getClassLoader().getResource("files/chromedriver.exe").getPath());
    }

    @BeforeMethod
    protected void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
    protected void browserTitle(String browserTitle) {
        assertEquals(driver.getTitle(), browserTitle);
    }

    //Assert user name
    protected void username(String expectedUsername) {
        WebElement actualUsername = driver.findElement(By.id("user-name"));
        // TODO It is better check visibility and after that text :)
        assertEquals(actualUsername.getText(), expectedUsername);
        assertTrue(actualUsername.isDisplayed());
    }
}

