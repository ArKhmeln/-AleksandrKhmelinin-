package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubtractionTest extends Base {

    @DataProvider
    public static Object[][] calcData() {
//        TODO Why you decide use this numbers?
        return new Object[][] {{4, 2, 2}, {55, 5, 50}, {6, 7, -1}};
    }

    @Test(dataProvider = "calcData")
    public void subtractionTest(long minuend, long subtrahend, long difference) {
        long actual = calculator.sub(minuend, subtrahend);
//        TODO Is this operation necessary?
        long expected = difference;
        assertEquals(actual, expected);
    }
}
