package hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

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

    @FindBy(css = "div[class='row clerafix benefits'] .benefit-icon")
    private List<WebElement> pageImages;

    @FindBy(css = ".main-content .benefit-txt")
    private List<WebElement> pageIconText;

    @FindBy(css = "[class$='text-center']:nth-child(-n+2)")
    private List<WebElement> mainHeaderText;

    @FindBy(id = "iframe")
    private WebElement iframe;

    @FindBy(id = "epam_logo")
    private WebElement epamLogo;

    @FindBy(css = ".text-center>a")
    private WebElement subHeaderText;

    @FindBy(linkText = "JDI GITHUB")
    private WebElement subHeaderLinkText;

    @FindBy(css = ".text-center>a")
    private WebElement subHeaderLink;

    @FindBy(id = "mCSB_1")
    private WebElement leftSection;

    @FindBy(css = ".footer-bg")
    private WebElement rightSection;

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

    public void fillInLoginNameTextField(String userName) {
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

    public List<WebElement> getPageImages() {
        return pageImages;
    }

    public List<WebElement> getPageIconText() {
        return pageIconText;
    }

    public List<WebElement> getMainHeaderText() {
        return mainHeaderText;
    }

    public WebElement getIframe() {
        return iframe;
    }

    public WebElement getEpamLogo() {
        return epamLogo;
    }

    public WebElement getSubHeaderText() {
        return subHeaderText;
    }

    public WebElement getSubHeaderLinkText() {
        return subHeaderLinkText;
    }

    public WebElement getSubHeaderLink() {
        return subHeaderLink;
    }

    public WebElement getLeftSection() {
        return leftSection;
    }

    public WebElement getRightSection() {
        return rightSection;
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
