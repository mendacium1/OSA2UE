import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PointTest {

	private static double DELTA = 0.0001;

	@ParameterizedTest
	@CsvSource({ "3, 4, 3, 4, 0", "3, 4, 0, 0, 5", "0, 0, -3, -2, 3.6056", "0, 0, 1, -1, 1.4142",
			"3, 6, 2, 4, 2.23606" })
	void testDistance(double x1, double y1, double x2, double y2, double expectedDistance) {
		Point p1 = new Point(x1, y1);
		Point p2 = new Point(x2, y2);

		assertEquals(expectedDistance, p1.distance(p2), DELTA);
		assertEquals(expectedDistance, p2.distance(p1), DELTA);
	}

	@Test
	void testDistanceSelf() {
		Point p = new Point(3, 4);

		assertEquals(0, p.distance(p), DELTA);
	}

}
