import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ClockTimeTest {

	@Test
	void testClockTimeIntIntInt() {
		ClockTime t = new ClockTime(14, 10, 0);
		assertEquals(14, t.getHours());
		assertEquals(10, t.getMinutes());
		assertEquals(0, t.getSeconds());

		t = new ClockTime(3, 2, 16);
		assertEquals(3, t.getHours());
		assertEquals(2, t.getMinutes());
		assertEquals(16, t.getSeconds());

		t = new ClockTime(-1, -20, -10);
		assertEquals(22, t.getHours());
		assertEquals(39, t.getMinutes());
		assertEquals(50, t.getSeconds());
	}

	@Test
	void testClockTimeIntInt() {
		ClockTime t = new ClockTime(14, 10);
		assertEquals(14, t.getHours());
		assertEquals(10, t.getMinutes());
		assertEquals(0, t.getSeconds());

		t = new ClockTime(3, 2);
		assertEquals(3, t.getHours());
		assertEquals(2, t.getMinutes());
		assertEquals(0, t.getSeconds());

		t = new ClockTime(-1, -20);
		assertEquals(22, t.getHours());
		assertEquals(40, t.getMinutes());
		assertEquals(0, t.getSeconds());
	}

	@Test
	void testClockTimeClockTime() {
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

	@Test
	void testNormalize() {
		ClockTime t = new ClockTime(14, 10, 0);
		assertEquals(14, t.getHours());
		assertEquals(10, t.getMinutes());
		assertEquals(0, t.getSeconds());

		t = new ClockTime(33, 72, 96);
		assertEquals(10, t.getHours());
		assertEquals(13, t.getMinutes());
		assertEquals(36, t.getSeconds());
	}

	@Test
	void testAddClockTime() {
		ClockTime t1 = new ClockTime(14, 10, 0);
		ClockTime t2 = new ClockTime(3, 27, 34);

		ClockTime result = t1.add(t2);
		assertEquals(17, result.getHours());
		assertEquals(37, result.getMinutes());
		assertEquals(34, result.getSeconds());

		// check that the original object is unchanged
		assertEquals(14, t1.getHours());
		assertEquals(10, t1.getMinutes());
		assertEquals(0, t1.getSeconds());

		t1 = new ClockTime(14, 10, 0);
		t2 = new ClockTime(3, 27, 34);

		result = t2.add(t1);
		assertEquals(17, result.getHours());
		assertEquals(37, result.getMinutes());
		assertEquals(34, result.getSeconds());

		assertEquals(3, t2.getHours());
		assertEquals(27, t2.getMinutes());
		assertEquals(34, t2.getSeconds());

		t1 = new ClockTime(14, 10, 0);
		result = t1.add(t1);
		assertEquals(4, result.getHours());
		assertEquals(20, result.getMinutes());
		assertEquals(0, result.getSeconds());

		assertEquals(14, t1.getHours());
		assertEquals(10, t1.getMinutes());
		assertEquals(0, t1.getSeconds());

		t1 = new ClockTime(14, 10, 0);
		t2 = new ClockTime(-3, 0);

		result = t1.add(t2);
		assertEquals(11, result.getHours());
		assertEquals(10, result.getMinutes());
		assertEquals(0, result.getSeconds());

		assertEquals(14, t1.getHours());
		assertEquals(10, t1.getMinutes());
		assertEquals(0, t1.getSeconds());
	}

	@Test
	void testAddInt() {
		ClockTime t = new ClockTime(14, 10, 0);

		ClockTime result = t.add(20);
		assertEquals(14, result.getHours());
		assertEquals(10, result.getMinutes());
		assertEquals(20, result.getSeconds());

		// check that the original object is unchanged
		assertEquals(14, t.getHours());
		assertEquals(10, t.getMinutes());
		assertEquals(0, t.getSeconds());

		t = new ClockTime(14, 10, 0);

		result = t.add(200);
		assertEquals(14, result.getHours());
		assertEquals(13, result.getMinutes());
		assertEquals(20, result.getSeconds());

		assertEquals(14, t.getHours());
		assertEquals(10, t.getMinutes());
		assertEquals(0, t.getSeconds());

		t = new ClockTime(14, 10, 0);

		result = t.add(4000);
		assertEquals(15, result.getHours());
		assertEquals(16, result.getMinutes());
		assertEquals(40, result.getSeconds());

		assertEquals(14, t.getHours());
		assertEquals(10, t.getMinutes());
		assertEquals(0, t.getSeconds());

		t = new ClockTime(14, 10, 0);

		result = t.add(-20);
		assertEquals(14, result.getHours());
		assertEquals(9, result.getMinutes());
		assertEquals(40, result.getSeconds());

		assertEquals(14, t.getHours());
		assertEquals(10, t.getMinutes());
		assertEquals(0, t.getSeconds());

		t = new ClockTime(14, 10, 0);

		result = t.add(-200);
		assertEquals(14, result.getHours());
		assertEquals(6, result.getMinutes());
		assertEquals(40, result.getSeconds());

		assertEquals(14, t.getHours());
		assertEquals(10, t.getMinutes());
		assertEquals(0, t.getSeconds());

		t = new ClockTime(14, 10, 0);

		result = t.add(-4000);
		assertEquals(13, result.getHours());
		assertEquals(3, result.getMinutes());
		assertEquals(20, result.getSeconds());

		assertEquals(14, t.getHours());
		assertEquals(10, t.getMinutes());
		assertEquals(0, t.getSeconds());
	}

	@Test
	void testSubtractClockTime() {
		ClockTime t1 = new ClockTime(14, 10, 0);
		ClockTime t2 = new ClockTime(3, 27, 34);

		ClockTime result = t1.subtract(t2);
		assertEquals(10, result.getHours());
		assertEquals(42, result.getMinutes());
		assertEquals(26, result.getSeconds());

		// check that the original object is unchanged
		assertEquals(14, t1.getHours());
		assertEquals(10, t1.getMinutes());
		assertEquals(0, t1.getSeconds());

		t1 = new ClockTime(14, 10, 0);
		t2 = new ClockTime(3, 27, 34);

		result = t2.subtract(t1);
		assertEquals(13, result.getHours());
		assertEquals(17, result.getMinutes());
		assertEquals(34, result.getSeconds());

		assertEquals(3, t2.getHours());
		assertEquals(27, t2.getMinutes());
		assertEquals(34, t2.getSeconds());

		t1 = new ClockTime(14, 10, 0);
		result = t1.subtract(t1);
		assertEquals(0, result.getHours());
		assertEquals(0, result.getMinutes());
		assertEquals(0, result.getSeconds());

		assertEquals(14, t1.getHours());
		assertEquals(10, t1.getMinutes());
		assertEquals(0, t1.getSeconds());

		t1 = new ClockTime(14, 10, 0);
		t2 = new ClockTime(-3, 0);

		result = t1.subtract(t2);
		assertEquals(17, result.getHours());
		assertEquals(10, result.getMinutes());
		assertEquals(0, result.getSeconds());

		assertEquals(14, t1.getHours());
		assertEquals(10, t1.getMinutes());
		assertEquals(0, t1.getSeconds());
	}

	@Test
	void testSubtractInt() {
		ClockTime t = new ClockTime(14, 10, 0);

		ClockTime result = t.subtract(20);
		assertEquals(14, result.getHours());
		assertEquals(9, result.getMinutes());
		assertEquals(40, result.getSeconds());

		// check that the original object is unchanged
		assertEquals(14, t.getHours());
		assertEquals(10, t.getMinutes());
		assertEquals(0, t.getSeconds());

		t = new ClockTime(14, 10, 0);

		result = t.subtract(200);
		assertEquals(14, result.getHours());
		assertEquals(6, result.getMinutes());
		assertEquals(40, result.getSeconds());

		assertEquals(14, t.getHours());
		assertEquals(10, t.getMinutes());
		assertEquals(0, t.getSeconds());

		t = new ClockTime(14, 10, 0);

		result = t.subtract(4000);
		assertEquals(13, result.getHours());
		assertEquals(3, result.getMinutes());
		assertEquals(20, result.getSeconds());

		assertEquals(14, t.getHours());
		assertEquals(10, t.getMinutes());
		assertEquals(0, t.getSeconds());

		t = new ClockTime(14, 10, 0);

		result = t.subtract(-20);
		assertEquals(14, result.getHours());
		assertEquals(10, result.getMinutes());
		assertEquals(20, result.getSeconds());

		assertEquals(14, t.getHours());
		assertEquals(10, t.getMinutes());
		assertEquals(0, t.getSeconds());

		t = new ClockTime(14, 10, 0);

		result = t.subtract(-200);
		assertEquals(14, result.getHours());
		assertEquals(13, result.getMinutes());
		assertEquals(20, result.getSeconds());

		assertEquals(14, t.getHours());
		assertEquals(10, t.getMinutes());
		assertEquals(0, t.getSeconds());

		t = new ClockTime(14, 10, 0);

		result = t.subtract(-4000);
		assertEquals(15, result.getHours());
		assertEquals(16, result.getMinutes());
		assertEquals(40, result.getSeconds());

		assertEquals(14, t.getHours());
		assertEquals(10, t.getMinutes());
		assertEquals(0, t.getSeconds());
	}

}
