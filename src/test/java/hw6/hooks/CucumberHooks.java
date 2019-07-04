package hw6.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CucumberHooks {

    //hook set will execute before each scenario and after

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        TestContext.setDriver(driver);
        driver.manage().window().maximize();
    }

    @After
    public void closeDriver() {
        TestContext.getDriver().close();
    }
    /*public static void closeBrowser() throws Exception{
        if (TestContext.getDriver() == null) {
            return;
        }
        TestContext.getDriver().quit();
        TestContext.getDriver() = null;
    }*/
}
