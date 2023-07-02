import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ParameterizedCalculatorTest {

	private static final double DELTA = 0.000000000001;

	private Calculator calculator;

	@BeforeEach
	void setup() {
		calculator = new Calculator();
	}

	@ParameterizedTest
	@CsvSource({ "1, 1, 2", "1, -1, 0", "-1, 1, 0", "-1, -1, -2" })
	void testAdd(double summand1, double summand2, double expectedResult) {
		double actualResult = calculator.add(summand1, summand2);
		assertEquals(expectedResult, actualResult, DELTA);
	}

}
