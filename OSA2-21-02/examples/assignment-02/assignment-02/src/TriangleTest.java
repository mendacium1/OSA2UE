import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TriangleTest {

	private double DELTA = 0.001;

	private Triangle t1;
	private Triangle t2;
	private Triangle t3;
	private Triangle t4;
	private Triangle t5;
	private Triangle t6;
	private Triangle t7;
	private Triangle t8;

	@BeforeEach
	public void setup() {
		// point
		t1 = new Triangle(new Point(0, 0), new Point(0, 0), new Point(0, 0));
		// right angle, a = b
		t2 = new Triangle(new Point(0, 0), new Point(3, 0), new Point(3, 3));
		// a = b = c
		t3 = new Triangle(new Point(8, 0), new Point(0, 0), new Point(4, 6.9282032303));
		// right angle,
		t4 = new Triangle(new Point(6, 0), new Point(0, 0), new Point(1.5, 2.5980762114));
		// line
		t5 = new Triangle(new Point(0, 0), new Point(3, 0), new Point(1, 0));
		// scalene triangle
		t6 = new Triangle(new Point(3, 0), new Point(0, 0), new Point(4.833333, 3.555121));
		t7 = new Triangle(new Point(0, 0), new Point(4.833333, 3.555121), new Point(3, 0));
		t8 = new Triangle(new Point(4.833333, 3.555121), new Point(3, 0), new Point(0, 0));
	}

	@Test
	public void testPerimeter1() {
		assertEquals(0, t1.perimeter(), DELTA);
	}

	@Test
	public void testPerimeter2() {
		assertEquals(10.243, t2.perimeter(), DELTA);
	}

	@Test
	public void testPerimeter3() {
		assertEquals(24, t3.perimeter(), DELTA);
	}

	@Test
	public void testPerimeter4() {
		assertEquals(14.196, t4.perimeter(), DELTA);
	}

	@Test
	public void testPerimeter5() {
		assertEquals(6, t5.perimeter(), DELTA);
	}

	@Test
	public void testPerimeter6() {
		assertEquals(13, t6.perimeter(), DELTA);
	}

	@Test
	public void testPerimeter7() {
		assertEquals(13, t7.perimeter(), DELTA);
	}

	@Test
	public void testPerimeter8() {
		assertEquals(13, t8.perimeter(), DELTA);
	}

	@Test
	public void testArea1() {
		assertEquals(0, t1.area(), DELTA);
	}

	@Test
	public void testArea2() {
		assertEquals(4.5, t2.area(), DELTA);
	}

	@Test
	public void testArea3() {
		assertEquals(27.713, t3.area(), DELTA);
	}

	@Test
	public void testArea4() {
		assertEquals(7.794, t4.area(), DELTA);
	}

	@Test
	public void testArea5() {
		assertEquals(0, t5.area(), DELTA);
	}

	@Test
	public void testArea6() {
		assertEquals(5.333, t6.area(), DELTA);
	}

	@Test
	public void testArea7() {
		assertEquals(5.333, t7.area(), DELTA);
	}

	@Test
	public void testArea8() {
		assertEquals(5.333, t8.area(), DELTA);
	}

}
