package hw4.pages;

import com.codeborne.selenide.SelenideElement;
import hw4.enums.metalsAndColors.Elements;
import hw4.enums.metalsAndColors.Result;
import hw4.enums.metalsAndColors.Vegetables;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class MetalsAndColors extends BasePage {

    public void clickSubmitButton() {
        $("#submit-button").click();
    }

    public void selectSummary(List<String> numbers) {
        if (numbers != null) {
            for (String number : numbers) {
                $(By.xpath("//p[contains(.//label, '" + number + "')]")).click();
            }
        }
    }

    public void selectElements(List<Elements> elements) {
        if (elements != null) {
            for (Elements element : elements) {
                $(By.xpath("//div[@id='elements-block']//label[contains(., '" + element.getText() + "')]")).click();
            }
        }
    }

    public void selectColor(String name) {
        if (name != null) {
            $(By.xpath("//button[@title='Colors']")).click();
            $(By.xpath("//li[contains(.//span, '" + name + "')]")).click();
        }
    }

    public void selectMetal(String name) {
        if (name != null) {
            $(By.xpath("//button[@type='button' and contains(.//span, 'Metals')]/span[@class='caret']")).click();
            $(By.xpath("//a[contains(.//span, '" + name + "')]")).click();
        }
    }

    public void selectVegetables(List<Vegetables> vegetables) {
        if (vegetables != null) {
            $("#salad-dropdown button").click();
            $(By.xpath("//div[@id='salad-dropdown']//label[contains(., 'Vegetables')]")).click();
            for (Vegetables vegetable: vegetables) {
                $(By.xpath("//div[@id='salad-dropdown']//label[contains(., '"+vegetable.getText()+"')]")).click();
            }
        }
    }

    //Result
    public SelenideElement getResult(Result name) {
        return $(By.xpath("//ul[@class='panel-body-list results']/li[contains(., '"+name.getText()+"')]"));
    }

    public String getSummaryResult(List<String> numbers) {
        Integer sum = 0;
        for(String number: numbers) {
             sum += Integer.parseInt(number);
        }
        return Integer.toString(sum);
    }
}
