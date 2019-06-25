package hw3.pages;

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

    //common elements for all pages

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement loginNameTextField;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userNameField;

    @FindBy(css = "ul[class$='navbar-nav m-l8']>li>a[href]," +
            " ul[class$='navbar-nav m-l8'] a.dropdown-toggle")
    private List<WebElement> headerSectionItems;

    @FindBy(id = "mCSB_1")
    private WebElement leftSection;

    @FindBy(css = ".footer-bg")
    private WebElement footer;

    @FindBy(css = "li.dropdown")
    private WebElement headerDropdownInService;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//li")
    private List<WebElement> headerDropdownTextInService;

    @FindBy(css = "li.menu-title")
    private WebElement leftSectionServiceDropdown;

    @FindBy(xpath = "//li[@class='menu-title' and contains(.//span, 'Service')]//li//span")
    private List<WebElement> leftSectionServiceDropdownText;

    @FindBy(css = "header .dropdown-toggle")
    private WebElement leftSectionService;

    @FindBy(xpath = "//a[contains(text(), 'Different elements')]")
    private WebElement leftSectionServiceDifferentElements;


    public void clickUserIcon() {
        userIcon.click();
    }

    public void fillTextFieldName(String userName) {
        loginNameTextField.sendKeys(userName);
    }

    public void enterPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public WebElement getUserNameElement() {
        return userNameField;
    }

    public List<WebElement> getHeaderSectionItems() {
        return headerSectionItems;
    }

    public WebElement getLeftSection() {
        return leftSection;
    }

    public WebElement getFooter() {
        return footer;
    }

    public WebElement getHeaderDropdownInService() {
        return headerDropdownInService;
    }

    public List<WebElement> getHeaderDropdownTextInService() {
        return headerDropdownTextInService;
    }

    public WebElement getLeftSectionServiceDropdown() {
        return leftSectionServiceDropdown;
    }

    public List<WebElement> getLeftSectionServiceDropdownText() {
        return leftSectionServiceDropdownText;
    }

    public WebElement getLeftSectionService() {
        return leftSectionService;
    }

    public WebElement getLeftSectionServiceDifferentElements() {
        return leftSectionServiceDifferentElements;
    }
}
