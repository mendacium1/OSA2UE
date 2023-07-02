import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	private static final double DELTA = 0.000000000001;

	private Calculator calculator;

	@BeforeEach
	void setup() {
		calculator = new Calculator();
	}

	@Test
	void testAddWithPositivIntegerPositivInteger() {
		double result = calculator.add(1, 1);
		assertEquals(2, result, DELTA);
	}

	@Test
	void testAddWithPositivIntegerNegativInteger() {
		double result = calculator.add(1, -1);
		assertEquals(0, result, DELTA);
	}

	@Test
	void testAddWithNegativIntegerPositivInteger() {
		double result = calculator.add(-1, 1);
		assertEquals(0, result, DELTA);
	}

	@Test
	void testAddWithNegativIntegerNegativInteger() {
		double result = calculator.add(-1, -1);
		assertEquals(-2, result, DELTA);
	}

	@Test
	void testAddWithPositiveDoublePositiveDouble() {
		double result = calculator.add(1.0, 1.0);
		assertEquals(2, result, DELTA);
	}

	@Test
	void testAddWithPositiveDoubleNegativeDouble() {
		double result = calculator.add(1.0, -1.0);
		assertEquals(0, result, DELTA);
	}

	@Test
	void testAddWithNegativeDoublePositiveDouble() {
		double result = calculator.add(-1.0, 1.0);
		assertEquals(0, result, DELTA);
	}

	@Test
	void testAddWithNegativeDoubleNegativeDouble() {
		double result = calculator.add(-1.0, -1.0);
		assertEquals(-2, result, DELTA);
	}

	@Test
	void testAddOverflow() {
		double result = calculator.add(Double.MAX_VALUE, 1.0);
		assertEquals(Double.MAX_VALUE, result, DELTA);
	}

	@Test
	void testAddMinimalOverflow() {
		double result = calculator.add(Double.MAX_VALUE, 1.0e292);
		assertEquals(Double.POSITIVE_INFINITY, result, DELTA);
	}

	@Test
	void testAddUnderflow() {
		double result = calculator.add(Double.MIN_VALUE, -1.0);
		assertEquals(-1, result, DELTA);
	}

	@Test
	void testAddMinimalUnderflow() {
		double result = calculator.add(Double.MIN_VALUE, -4.9e-324);
		assertEquals(0, result, DELTA);
	}

	@Test
	void testSubtractWithPositiveIntegerPositiveInteger() {
		double result = calculator.subtract(1, 1);
		assertEquals(0, result, DELTA);
	}

	@Test
	void testSubtractWithPositiveIntegerNegativeInteger() {
		double result = calculator.subtract(1, -1);
		assertEquals(2, result, DELTA);
	}

	@Test
	void testSubtractWithNegativeIntegerPositiveInteger() {
		double result = calculator.subtract(-1, 1);
		assertEquals(-2, result, DELTA);
	}

	@Test
	void testSubtractWithNegativeIntegerNegativeInteger() {
		double result = calculator.subtract(-1, -1);
		assertEquals(0, result, DELTA);
	}

	@Test
	void testSubtractWithPositiveDoublePositiveDouble() {
		double result = calculator.subtract(1.0, 1.0);
		assertEquals(0, result, DELTA);
	}

	@Test
	void testSubtractWithPositiveDoubleNegativeDouble() {
		double result = calculator.subtract(1.0, -1.0);
		assertEquals(2, result, DELTA);
	}

	@Test
	void testSubtractWithNegativeDoublePositiveDouble() {
		double result = calculator.subtract(-1.0, 1.0);
		assertEquals(-2, result, DELTA);
	}

	@Test
	void testSubtractWithNegativeDoubleNegativeDouble() {
		double result = calculator.subtract(-1.0, -1.0);
		assertEquals(0, result, DELTA);
	}

	@Test
	void testSubtractWithFractionDoubles() {
		double result = calculator.subtract(2.0, -1.1);
		assertEquals(3.1, result, DELTA);
	}

	@Test
	void testSubtractOverflow() {
		double result = calculator.subtract(Double.MAX_VALUE, -1.0);
		assertEquals(Double.MAX_VALUE, result, DELTA);
	}

	@Test
	void testSubtractMinimalOverflow() {
		double result = calculator.subtract(Double.MAX_VALUE, -1.0e292);
		assertEquals(Double.POSITIVE_INFINITY, result, DELTA);
	}

	@Test
	void testSubtractUnderflow() {
		double result = calculator.subtract(Double.MIN_VALUE, 1.0);
		assertEquals(-1, result, DELTA);
	}

	@Test
	void testSubtractMinimalUnderflow() {
		double result = calculator.subtract(Double.MIN_VALUE, 4.9e-324);
		assertEquals(0, result, DELTA);
	}

	@Test
	void testMultiplyWithPositiveIntegerPositiveInteger() {
		double result = calculator.multiply(1, 1);
		assertEquals(1, result, DELTA);
	}

	@Test
	void testMultiplyWithPositiveIntegerNegativeInteger() {
		double result = calculator.multiply(1, -1);
		assertEquals(-1, result, DELTA);
	}

	@Test
	void testMultiplyWithNegativeIntegerPositiveInteger() {
		double result = calculator.multiply(-1, 1);
		assertEquals(-1, result, DELTA);
	}

	@Test
	void testMultiplyWithNegativeIntegerNegativeInteger() {
		double result = calculator.multiply(-1, -1);
		assertEquals(1, result, DELTA);
	}

	@Test
	void testMultiplyWithZeroInteger() {
		double result = calculator.multiply(1, 0);
		assertEquals(0, result, DELTA);
	}

	@Test
	void testMultiplyWithPositiveDoublePositiveDouble() {
		double result = calculator.multiply(1.0, 1.0);
		assertEquals(1, result, DELTA);
	}

	@Test
	void testMultiplyWithPositiveDoubleNegativeDouble() {
		double result = calculator.multiply(1.0, -1.0);
		assertEquals(-1, result, DELTA);
	}

	@Test
	void testMultiplyWithNegativeDoublePositiveDouble() {
		double result = calculator.multiply(-1.0, 1.0);
		assertEquals(-1, result, DELTA);
	}

	@Test
	void testMultiplyWithNegativeDoubleNegativeDouble() {
		double result = calculator.multiply(-1.0, -1.0);
		assertEquals(1, result, DELTA);
	}

	@Test
	void testMultiplyWithZeroDobule() {
		double result = calculator.multiply(1.0, 0.0);
		assertEquals(0, result, DELTA);
	}

	@Test
	void testMultiplyOverflow() {
		double result = calculator.multiply(Double.MAX_VALUE, 2);
		assertEquals(Double.POSITIVE_INFINITY, result, DELTA);
	}

	@Test
	void testMultiplyMinimalOverflow() {
		double result = calculator.multiply(Double.MAX_VALUE, 1e308);
		assertEquals(Double.POSITIVE_INFINITY, result, DELTA);
	}

	@Test
	void testMultiplyUnderflow() {
		double result = calculator.multiply(Double.MIN_VALUE, Double.MIN_VALUE);
		assertEquals(0, result, DELTA);
	}

	@Test
	void testMultiplyMinimalUnderflow() {
		double result = calculator.multiply(Double.MIN_VALUE, 4.9e-324);
		assertEquals(0, result, DELTA);
	}
}
