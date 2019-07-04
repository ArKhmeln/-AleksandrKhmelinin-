package hw6.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement loginNameTextField;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement loginButton;

    @FindBy(css = "li.dropdown")
    private WebElement serviceInTheHeader;

    @Getter
    @FindBy(xpath = "//ul[@class='dropdown-menu']//li")
    private List<WebElement> serviceElementsInTheHeader;

    @FindBy(css = "li.menu-title")
    private WebElement serviceInTheLeftSection;

    @Getter
    @FindBy(xpath = "//li[@class='menu-title'and contains(.//span, 'Service')]//li//span")
    private List<WebElement> serviceElementsInTheLeftSection;

    @FindBy(xpath = "//header//a[contains(text(), 'Different elements')]")
    private WebElement differentElementsInServiceInTheHeader;

    @FindBy(xpath = "//header//ul[@class='dropdown-menu']/li[contains(., 'User Table ')]")
    private WebElement userTableInServiceInTheHeader;

    @Getter
    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private List<WebElement> logs;

    public void userIconClick() {
        userIcon.click();
    }

    public void fillLoginTextField(String username) {
        loginNameTextField.sendKeys(username);
    }

    public void fillPasswordTextField(String password) {
        this.password.sendKeys(password);
    }

    public void loginButtonClick() {
        loginButton.click();
    }

    public void serviceInTheHeaderClick() {
        serviceInTheHeader.click();
    }

    public void serviceInTheLeftSectionClick() {
        serviceInTheLeftSection.click();
    }

    public void differentElementsInServiceInTheHeaderClick() {
        differentElementsInServiceInTheHeader.click();
    }

    public void userTableInServiceInTheHeaderClick() {
        userTableInServiceInTheHeader.click();
    }
}
