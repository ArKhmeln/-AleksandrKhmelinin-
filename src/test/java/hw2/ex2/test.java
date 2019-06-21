package hw2.ex2;

import hw2.hw2Base.Hw2BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class test extends Hw2BaseTest {

    @Test
    public void test() {
        goToWebsite("https://epam.github.io/JDI");
        assertBrowserTitle("Home Page");
        login("epam", "1234");
        driver.findElement(By.cssSelector("header .dropdown-toggle")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Different elements')]")).click();

        List<WebElement> re = driver.findElements(By.className("label-checkbox"));
        for(WebElement el: re) {
            System.out.println(el.getText());
        }
        /*
            //11. Select checkboxes
            // TODO This method should be parametrized      -fixed
            protected void selectCheckbox(int checkboxNumber1, int checkboxNumber2) {
                // TODO This locators could be improved
                driver.findElement(By.xpath("//label[@class='label-checkbox']["+checkboxNumber1+"]")).click();
                driver.findElement(By.xpath("//label[@class='label-checkbox']["+checkboxNumber2+"]")).click();
            }



         */
    }
}
