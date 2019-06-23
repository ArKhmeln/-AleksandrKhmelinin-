package hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

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
}
