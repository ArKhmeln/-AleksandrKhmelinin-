package lesson1;

import org.testng.Assert;
import org.testng.annotations.*;

public class Example01 {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before suite");
    }

    @BeforeTest
    public void beforeSTest() {
        System.out.println("before test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("before class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before method");
    }

    @Test
    public void substractTest() {
        System.out.println("test2");
        Assert.assertEquals(2 - 2, 0);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("after method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("after class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("after test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("after suite");
    }
}
