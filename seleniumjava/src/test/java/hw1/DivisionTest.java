package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivisionTest extends BeforeMethods {

    @DataProvider
    public static Object[][] calcData() {
        return new Object[][] {{4, 2, 2}, {21, 7, 3}, {100, 10, 10}};
    }

    @Test(dataProvider = "calcData")
    public void divisionTest(long dividend, long divisor, long quotient) {
        long actual = calculator.div(dividend, divisor);
        long expected = quotient;
        assertEquals(actual, expected);
    }
}
