package lesson2;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Example2 extends BaseTest {

    @Test
    public void seleniumOpenPageTest() {
        Assert.assertEquals(driver.getTitle(), "Home Page");

        driver.findElement(By.linkText("Metals & Colors")).click();
    }

    @Test
    public void loginTest() {
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#password")).sendKeys("1234");
        driver.findElement(By.xpath("//button[@id='login-button']")).click();

        Assert.assertEquals(driver.findElement(By.id("user-name"))
                .getText(), "PITER CHAILOVSKII");
    }
}
