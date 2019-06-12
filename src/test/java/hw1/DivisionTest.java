package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivisionTest extends Base {

    @DataProvider
    public static Object[][] calcData() {
        // TODO Why you decide use this numbers?    fixed
        return new Object[][] {{-5, -5, 1}, {42, -7, -6}, {100, 10, 10}};
    }

    @Test(dataProvider = "calcData")
    public void divisionTest(long dividend, long divisor, long expected) {
        long actual = calculator.div(dividend, divisor);
        //        TODO Is this operation necessary?     fixed
        assertEquals(actual, expected);
    }
}
