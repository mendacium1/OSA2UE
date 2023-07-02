/**
 * A {@link Quadrangle} with two pairs of parallel sides.
 * 
 * @author Claudia
 * @version 1.0
 */
public class Parallelogram extends Rectangle {

	/**
	 * One of the two angles in the object.
	 */
	double alpha;

	public Parallelogram(double side, double otherSide, double alpha) {
		super(side, otherSide);
		this.alpha = alpha;
	}

	public double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	/*
	 * (non-Javadoc)
	 * @see Rectangle#getArea()
	 */
	@Override
	public double getArea() {
		return side * otherSide * Math.sin(alpha);
	}

	/*
	 * (non-Javadoc)
	 * @see Rectangle#getDiagonals()
	 */
	@Override
	public double[] getDiagonals() {
		return new double[] { getDiagonalE(), getDiagonalF() };
	}

	/**
	 * @return one of the two diagonals
	 */
	private double getDiagonalE() {
		return Math.sqrt(side * side + otherSide * otherSide + 2 * side * otherSide * Math.cos(alpha));
	}

	/**
	 * @return the other of the two diagonals
	 */
	private double getDiagonalF() {
		return Math.sqrt(side * side + otherSide * otherSide - 2 * side * otherSide * Math.cos(alpha));
	}

}
