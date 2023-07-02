/**
 * A {@link Quadrangle} with four sides of equal length and four right angles.
 * 
 * @author Claudia Maderthaner
 * @version 1.0
 */
public class Square extends AbstractQuadrangle {

	/**
	 * The length of a side of the square.
	 * <p>
	 * This length applies to all four sides.
	 */
	double side;

	/**
	 * Create a new square object.
	 * 
	 * @param side
	 *            the length of the sides of the square
	 */
	public Square(double side) {
		this.side = side;
	}

	double getSide() {
		return side;
	}

	void setSide(double side) {
		this.side = side;
	}

	/*
	 * (non-Javadoc)
	 * @see Quadrangle#getArea()
	 */
	@Override
	public double getArea() {
		return side * side;
	}

	/*
	 * (non-Javadoc)
	 * @see Quadrangle#getPerimeter()
	 */
	@Override
	public double getPerimeter() {
		return 4 * side;
	}

	/*
	 * (non-Javadoc)
	 * @see Quadrangle#getDiagonals()
	 */
	@Override
	public double[] getDiagonals() {
		double diagonal = getDiagonal();
		return new double[] { diagonal, diagonal };
	}

	/**
	 * @return the length of a diagonal; this length applies to both diagonals
	 *         of the square
	 */
	double getDiagonal() {
		return Math.sqrt(side * side);
	}

}
