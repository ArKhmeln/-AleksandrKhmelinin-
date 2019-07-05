package hw6.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DifferentElementsPage extends BasePage {

    private static DifferentElementsPage instance;

    private DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public static DifferentElementsPage getInstance(WebDriver driver) {
        if (instance == null || instance.driver != driver) {
            instance = new DifferentElementsPage(driver);
        }
        return instance;
    }

    @Getter
    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxes;

    @Getter
    @FindBy(className = "label-radio")
    private List<WebElement> radiobuttons;

    @Getter
    @FindBy(css = ".colors>.uui-form-element")
    private List<WebElement> dropdown;

    @Getter
    @FindBy(css = ".colors>.uui-form-element")
    private WebElement dropdownMenu;

    @Getter
    @FindBy(css = ".main-content-hg>.uui-button")
    private List<WebElement> buttons;

    @Getter
    @FindBy(css = "[class~='right-fix-panel']")
    private WebElement rightSection;

    @Getter
    @FindBy(id = "mCSB_1_container")
    private WebElement leftSection;

    @Getter
    @FindBy(css = "select.uui-form-element option")
    private List<WebElement> dropdownMenuElements;
}
