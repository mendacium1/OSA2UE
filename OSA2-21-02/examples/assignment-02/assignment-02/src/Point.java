/**
 * Represents points in the cartesian coordinate system.
 * <p>
 * Each point is specified by a x- and an y-coordinate system.
 *
 * @author Claudia
 */
public class Point {

	/**
	 * The x-coordinate of the point in the Cartesian coordinate system.
	 */
	private final double x;
	/**
	 * The y-coordinate of the point in the Cartesian coordinate system.
	 */
	private final double y;

	/**
	 * Create a new point in the Cartesian coordinate system.
	 *
	 * @param x
	 *            the x-coordinate
	 * @param y
	 *            the y-coordinate
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the x-coordinate
	 */
	public double getX() {
		return x;
	}

	/**
	 * @return the y-coordinate
	 */
	public double getY() {
		return y;
	}

	/**
	 * Calculate the distance between this an the given other point.
	 *
	 * @param p
	 *            the other point
	 * @return the distance between the two points
	 */
	public double distance(Point p) {
		return Math.hypot(x - p.getX(), y - p.getY());
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Point (" + x + "," + y + ")";
	}

}
