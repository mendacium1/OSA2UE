import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ClockTimeParameterizedTest {

	@ParameterizedTest
	@CsvSource({ "14, 10, 0, 14, 10, 0", "3, 2, 16, 3, 2, 16", "-1, -20, -10, 22, 39, 50" })
	void testClockTimeIntIntInt(int hours, int minutes, int seconds, int expectedHours, int expectedMinutes,
			int expectedSeconds) {
		ClockTime t = new ClockTime(hours, minutes, seconds);
		assertEquals(expectedHours, t.getHours());
		assertEquals(expectedMinutes, t.getMinutes());
		assertEquals(expectedSeconds, t.getSeconds());
	}

	@ParameterizedTest
	@CsvSource({ "14, 10, 14, 10, 0", "3, 2, 3, 2, 0", "-1, -20, 22, 40, 0" })
	public void testClockTimeIntInt(int hours, int minutes, int expectedHours, int expectedMinutes,
			int expectedSeconds) {
		ClockTime t = new ClockTime(hours, minutes);
		assertEquals(expectedHours, t.getHours());
		assertEquals(expectedMinutes, t.getMinutes());
		assertEquals(expectedSeconds, t.getSeconds());
	}

	@Test
	public void testClockTimeClockTime() {
		ClockTime t1 = new ClockTime(14, 10, 0);
		ClockTime t2 = new ClockTime(t1);

		assertEquals(14, t2.getHours());
		assertEquals(10, t2.getMinutes());
		assertEquals(0, t2.getSeconds());

		t1 = new ClockTime(-1, -20);
		t2 = new ClockTime(t1);
		assertEquals(22, t2.getHours());
		assertEquals(40, t2.getMinutes());
		assertEquals(0, t2.getSeconds());
	}

	@ParameterizedTest
	@CsvSource({ "14, 10, 0, 14, 10, 0", "33, 72, 96, 10, 13, 36" })
	public void testNormalize(int hours, int minutes, int seconds, int expectedHours, int expectedMinutes,
			int expectedSeconds) {
		ClockTime t = new ClockTime(hours, minutes, seconds);
		assertEquals(expectedHours, t.getHours());
		assertEquals(expectedMinutes, t.getMinutes());
		assertEquals(expectedSeconds, t.getSeconds());
	}

	@ParameterizedTest
	@CsvSource({ "14, 10, 0, 3, 27, 34, 17, 37, 34", "3, 27, 34, 14, 10, 0, 17, 37, 34",
			"14, 10, 0, -3, 0, 0, 11, 10, 0" })
	public void testAddClockTime(int hours1, int minutes1, int seconds1, int hours2, int minutes2, int seconds2,
			int expectedHours, int expectedMinutes, int expectedSeconds) {
		ClockTime t1 = new ClockTime(hours1, minutes1, seconds1);
		ClockTime t2 = new ClockTime(hours2, minutes2, seconds2);

		ClockTime result = t1.add(t2);
		assertEquals(expectedHours, result.getHours());
		assertEquals(expectedMinutes, result.getMinutes());
		assertEquals(expectedSeconds, result.getSeconds());

		// check that the original object is unchanged
		assertEquals(hours1, t1.getHours());
		assertEquals(minutes1, t1.getMinutes());
		assertEquals(seconds1, t1.getSeconds());
	}

	@Test
	void testAddSelf() {
		ClockTime t1 = new ClockTime(14, 10, 0);

		ClockTime result = t1.add(t1);
		assertEquals(4, result.getHours());
		assertEquals(20, result.getMinutes());
		assertEquals(0, result.getSeconds());

		// check that the original object is unchanged
		assertEquals(14, t1.getHours());
		assertEquals(10, t1.getMinutes());
		assertEquals(0, t1.getSeconds());
	}

	@ParameterizedTest
	@CsvSource({ "14, 10, 0, 20, 14, 10, 20", "14, 10, 0, 200, 14, 13, 20", "14, 10, 0, 4000, 15, 16, 40",
			"14, 10, 0, -20, 14, 9, 40", "14, 10, 0, -200, 14, 6, 40", "14, 10, 0, -4000, 13, 3, 20" })
	public void testAddInt(int hours, int minutes, int seconds, int secondsToAdd, int expectedHours,
			int expectedMinutes, int expectedSeconds) {
		ClockTime t = new ClockTime(hours, minutes, seconds);

		ClockTime result = t.add(secondsToAdd);
		assertEquals(expectedHours, result.getHours());
		assertEquals(expectedMinutes, result.getMinutes());
		assertEquals(expectedSeconds, result.getSeconds());

		// check that the original object is unchanged
		assertEquals(hours, t.getHours());
		assertEquals(minutes, t.getMinutes());
		assertEquals(seconds, t.getSeconds());
	}

	@ParameterizedTest
	@CsvSource({ "14, 10, 0, 3, 27, 34, 10, 42, 26", "3, 27, 34, 14, 10, 0, 13, 17, 34",
			"14, 10, 0, -3, 0, 0, 17, 10, 0" })
	public void testSubtractClockTime(int hours1, int minutes1, int seconds1, int hours2, int minutes2, int seconds2,
			int expectedHours, int expectedMinutes, int expectedSeconds) {
		ClockTime t1 = new ClockTime(hours1, minutes1, seconds1);
		ClockTime t2 = new ClockTime(hours2, minutes2, seconds2);

		ClockTime result = t1.subtract(t2);
		assertEquals(expectedHours, result.getHours());
		assertEquals(expectedMinutes, result.getMinutes());
		assertEquals(expectedSeconds, result.getSeconds());

		// check that the original object is unchanged
		assertEquals(hours1, t1.getHours());
		assertEquals(minutes1, t1.getMinutes());
		assertEquals(seconds1, t1.getSeconds());
	}

	@Test
	void testSubtractSelf() {
		ClockTime t1 = new ClockTime(14, 10, 0);

		ClockTime result = t1.subtract(t1);
		assertEquals(0, result.getHours());
		assertEquals(0, result.getMinutes());
		assertEquals(0, result.getSeconds());

		// check that the original object is unchanged
		assertEquals(14, t1.getHours());
		assertEquals(10, t1.getMinutes());
		assertEquals(0, t1.getSeconds());
	}

	@ParameterizedTest
	@CsvSource({ "14, 10, 0, 20, 14, 9, 40", "14, 10, 0, 200, 14, 6, 40", "14, 10, 0, 4000, 13, 3, 20",
			"14, 10, 0, -20, 14, 10, 20", "14, 10, 0, -200, 14, 13, 20", "14, 10, 0, -4000, 15, 16, 40" })
	public void testSubtractInt(int hours, int minutes, int seconds, int secondsToSubtract, int expectedHours,
			int expectedMinutes, int expectedSeconds) {
		ClockTime t = new ClockTime(hours, minutes, seconds);

		ClockTime result = t.subtract(secondsToSubtract);
		assertEquals(expectedHours, result.getHours());
		assertEquals(expectedMinutes, result.getMinutes());
		assertEquals(expectedSeconds, result.getSeconds());

		// check that the original object is unchanged
		assertEquals(hours, t.getHours());
		assertEquals(minutes, t.getMinutes());
		assertEquals(seconds, t.getSeconds());
	}
}
