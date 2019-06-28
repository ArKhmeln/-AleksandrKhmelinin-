package hw4.hw4Base;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import hw4.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.open;
import static hw4.enums.general.WebsiteAndUserInfo.*;

public class BaseTest {

    protected HomePage homePage;

    @BeforeSuite
    public void config() {
        Configuration.browser = Browsers.CHROME;
        Configuration.pollingInterval = 500;
        Configuration.timeout = 5000;
        Configuration.reportsFolder = "target/selenide/reports/test";
        Configuration.startMaximized = true;
    }

    @BeforeMethod
    public void setUp() {
        //1. Open test site by URL
        homePage = open(LINK_MAIN.getText(), HomePage.class);
        //2. Assert Browser title
        homePage.pageTitle().shouldHave(attribute("text", PAGE_TITLE.getText()));
        //3. Perform login
        homePage.login(LOGIN, PASSWORD);
    }
}
