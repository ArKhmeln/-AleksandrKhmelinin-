package hw4.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.general.WebsiteAndUserInfo;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public abstract class BasePage {

    public SelenideElement pageTitle() {
        return $("title");
    }

    public void login(WebsiteAndUserInfo userName, WebsiteAndUserInfo password) {
        $(By.id("user-icon")).click();
        $(By.id("name")).sendKeys(userName.getText());
        $(By.id("password")).sendKeys(password.getText());
        $(By.xpath("//button[@id='login-button']")).click();
    }

    public SelenideElement userName() {
        return $("#user-name");
    }

    public ElementsCollection serviceElementsFromHeader() {
        return clickAndGetElements($("li.dropdown"), $$(By.xpath("//ul[@class='dropdown-menu']//li")));
    }

    public ElementsCollection serviceElementsFromLeftSection() {
        return clickAndGetElements($("li.menu-title"), $$(By.xpath("//li[@class='menu-title' " +
                "and contains(.//span, 'Service')]//li//span")));
    }

    public ElementsCollection clickAndGetElements(SelenideElement clickElement, ElementsCollection elementsList) {
        clickElement.click();
        return elementsList;
    }

    public void clickTableWithPagesInHeaderService() {
        $("li.dropdown").click();
        $$("header a").findBy(text("Table with pages")).click();
    }

    public SelenideElement leftSection() {
        return $(By.id("mCSB_1"));
    }

    public void goToMetalsAndColors() {
        $(By.xpath("//header//a[contains(., 'Metals & Colors')]")).click();
    }
}
