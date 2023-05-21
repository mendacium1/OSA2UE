import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    static final double DELTA = 0.0001;

    /**
     * Test with valid points for two triangles.
     * @param ax
     * @param ay
     * @param bx
     * @param by
     * @param cx
     * @param cy
     * @param resultPerimeter
     * @param resultArea
     */
    @ParameterizedTest
    @CsvSource({"1, 2, -3, 4, 12.34, -56.78, 127.0219, 106.22"})
    public void ValidTriangleTest(double ax, double ay, double bx, double by, double cx, double cy, double resultPerimeter, double resultArea) {
        Point pointA = new Point(ax, ay);
        Point pointB = new Point(bx, by);
        Point pointC = new Point(cx, cy);
        Triangle testTriangle = new Triangle(pointA, pointB, pointC);
        assertEquals(testTriangle.perimeter(), resultPerimeter, DELTA);
        assertEquals(testTriangle.area(), resultArea, DELTA);
    }


    /**
     * Test with invalid points for two triangles.
     * @param ax
     * @param ay
     * @param bx
     * @param by
     * @param cx
     * @param cy
     */
    @ParameterizedTest
    @CsvSource({"1, 2, 10, 12.34, 10, 12.34, No valid triangle possible with given points!"})
    public void ValidTriangleTest(double ax, double ay, double bx, double by, double cx, double cy, String expectedMessage) {
        Point pointA = new Point(ax, ay);
        Point pointB = new Point(bx, by);
        Point pointC = new Point(cx, cy);

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Triangle(pointA, pointB, pointC));
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}