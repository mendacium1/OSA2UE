/**
 * Represents triangles in the cartesian coordinate system.
 * <p>
 * Each triangle is specified three {@link Point}.
 *
 * @author Claudia
 */
public class Triangle {

	/**
	 * A corner point of the triangle
	 *
	 * @see Point
	 */
	private final Point a;
	/**
	 * A corner point of the triangle
	 *
	 * @see Point
	 */
	private final Point b;
	/**
	 * A corner point of the triangle
	 *
	 * @see Point
	 */
	private final Point c;

	/**
	 * Create a new triangle with the three given corner points.
	 *
	 * @param a
	 *            corner point a
	 * @param b
	 *            corner point b
	 * @param c
	 *            corner point c
	 */
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	 * Calculate the perimeter of this triangle.
	 * <p>
	 * The perimeter is the sum of the distances between the three corner points.
	 *
	 * @return the perimeter
	 */
	public double perimeter() {
		return a.distance(b) + b.distance(c) + c.distance(a);
	}

	/**
	 * Calculate the area of this triangle
	 *
	 * @return the area
	 */
	public double area() {
		double sideA = a.distance(b);
		double sideB = b.distance(c);
		double sideC = c.distance(a);
		double s = (sideA + sideB + sideC) / 2;
		return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
	}
}
