/**
 * A {@link Quadrangle} with four right angles.
 * <p>
 * Two sides at a time have the same length.
 * 
 * @author Claudia
 * @version 1.0
 */
public class Rectangle extends Square {

	/**
	 * The length of two of the four sides.
	 */
	protected double otherSide;

	public Rectangle(double sideA, double sideB) {
		super(sideA);
		otherSide = sideB;
	}

	double getOtherSide() {
		return otherSide;
	}

	void setOtherSide(double otherSide) {
		this.otherSide = otherSide;
	}

	/**
	 * @see Square#getArea()
	 */
	@Override
	public double getArea() {
		return side * otherSide;
	}

	/**
	 * @see Square#getPerimeter()
	 */
	@Override
	public double getPerimeter() {
		return 2 * (side + otherSide);
	}

	/**
	 * @return the length of a diagonal; this length applies to both diagonals
	 *         of the square
	 */
	@Override
	double getDiagonal() {
		return Math.sqrt(side * otherSide);
	}

}
