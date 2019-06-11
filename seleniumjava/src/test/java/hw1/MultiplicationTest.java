package hw1;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultiplicationTest extends Base {

    @DataProvider
    public static Object[][] calcData() {
        return new Object[][] {{2, 2, 4}, {3, 7, 21}, {6, 7, 42}};
    }

    @Test(dataProvider = "calcData")
    public void multiplicationTest(long multiplicand, long factor, long composition) {
        long actual = calculator.mult(multiplicand, factor);
        long expected = composition;
        assertEquals(actual, expected);
    }
}
