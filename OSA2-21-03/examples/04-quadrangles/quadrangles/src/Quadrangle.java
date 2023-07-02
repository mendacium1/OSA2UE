/**
 * Defines basic methods for quadrangles.
 * 
 * @author Claudia
 * @version 1.0
 */
public interface Quadrangle {

	/**
	 * Calculates and returns the area of the quadrangle.
	 * 
	 * @return the area of the quadrangle
	 */
	double getArea();

	/**
	 * Calculates and returns the perimeter of the quadrangle.
	 * 
	 * @return the perimeter of the quadrangle
	 */
	double getPerimeter();

	/**
	 * Calculates and returns the diagonal of the quadrangle.
	 * 
	 * @return an double array containing the two diagonals of the quadrangle
	 */
	double[] getDiagonals();

	/**
	 * @param q
	 *            the other quadrangle to compare to
	 * @return a negative integer, zero, or a positive integer as this
	 *         quadrangle is less than, equal to, or greater than the specified
	 *         quadrangle.
	 */
	int compareBySize(Quadrangle q);
}
