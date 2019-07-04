package hw6.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    private static HomePage instance;

    private HomePage(WebDriver driver) {
        super(driver);
    }

    public static HomePage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new HomePage(driver);
        }
        return instance;
    }

    @Getter
    @FindBy(css = "div[class='row clerafix benefits'] .benefit-icon")
    private List<WebElement> pictures;

    @Getter
    @FindBy(css = ".main-content .benefit-txt")
    List<WebElement> textsUnderPictures;

    @Getter
    @FindBy(css = "h3[name=main-title], p[name=jdi-text]")
    List<WebElement> headlineAndDescription;
}
