package hw6.pages;

import hw6.enums.UserTables;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserTablePage extends BasePage {

    private static UserTablePage instance;

    private UserTablePage(WebDriver driver) {
        super(driver);
    }

    public static UserTablePage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new UserTablePage(driver);
        }
        return instance;
    }

    @Getter
    @FindBy(css = "#user-table select")
    private List<WebElement> numberTypeDropdownsOnUsersTable;

    @Getter
    @FindBy(css = "#user-table a[href]")
    private List<WebElement> userNamesOnUsersTable;

    @Getter
    @FindBy(css = "#user-table img")
    private List<WebElement> descriptionImagesOnUsersTable;

    @Getter
    @FindBy(css = "#user-table span")
    private List<WebElement> descriptionTextsUnderImages;

    @Getter
    @FindBy(xpath = "//table[@id='user-table']//td[contains(text(), .)]")
    private List<WebElement> numbersOnUsersTable;

    public void vipCheckboxOnUsersTableClickByName(UserTables name) {
        driver.findElement(By.xpath("//table[@id='user-table']//tr[contains(., '"+name.getText()+"')]//input")).click();
    }

    public void dropdownOnUsersTableClickByName(UserTables name) {
        driver.findElement(By.xpath("//table[@id='user-table']//tr[contains(.,'"+name.getText()+"')]//select")).click();
    }

    public List<WebElement> getDropdownElementsOnUsersTableByName(UserTables name) {
        return driver.findElements(By.xpath("//table[@id='user-table']" +
                "//tr[contains(.,'"+name.getText()+"')]//select/option"));
    }
}
