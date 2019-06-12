package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SumTest extends Base {

    @DataProvider
    public static Object[][] calcData() {
        // TODO Why you decide use this numbers?
        return new Object[][] {{2, 2, 4}, {3, 7, 10}, {11, 15, 26}};
    }

    @Test(dataProvider = "calcData")
    public void sumTest(long summand1, long summand2, long addition) {
        long actual = calculator.sum(summand1, summand2);
//        TODO Is this operation necessary?
        long expected = addition;
        assertEquals(actual, expected);
    }
}
