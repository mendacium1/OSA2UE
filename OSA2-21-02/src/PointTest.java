import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {

    static final double DELTA = 0.0001;
    static final Point TESTPOINT = new Point(42, 42);
    @ParameterizedTest
    @CsvSource({"1, 2, 57.28", "-3, 4, 58.8982", "12.34, -56.78, 103.1368", "-98.7, 65, 142.5675"})
    public void PointTest(double x, double y, double result){
        Point testPoint = new Point(x, y);
        assertEquals(TESTPOINT.distance(testPoint), result, DELTA);
    }

}