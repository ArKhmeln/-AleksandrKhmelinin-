package hw4.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TableWithPages extends BasePage {

    public SelenideElement rightSection() {
        return $(By.name("log-sidebar"));
    }

    public SelenideElement showEntries(int number) {
        return $(By.xpath("//label[contains(text(), 'Show')]//option[@value='"+number+"']"));
    }

    public void selectEntryInDropdown(int number) {
        $(By.xpath("//label[contains(text(), 'Show')]")).click();
        $(By.xpath("//label[contains(text(), 'Show')]//option[@value='"+number+"']")).click();
    }

    public SelenideElement checkLogLengthValue(int expected) {
        return $(By.xpath("//section[contains(.//div, 'Log')]//ul/li[contains(text(), 'new value="+expected+"')]"));
    }

    public ElementsCollection dataTable() {
        return $$("#table-with-pages tbody tr[role='row']");
    }

    public SelenideElement typeInSearch(String text) {
        return $(By.xpath(".//label[contains(text(), 'Search')]/input")).setValue(text);
    }
}
