/**
 * The calculator class implements basic mathical operations:
 * <ul>
 * <li>addition ({@link #add(double, double)}
 * <li>subtraction ({@link #subtract(double, double)}
 * <li>multiplication ({@link #multiply(double, double)}
 * </ul>
 *
 * @author Claudia
 * @version 1.0
 *
 */
public class Calculator {

	/**
	 * This method adds two double values.
	 *
	 * @param summand1
	 *            a summand
	 * @param summand2
	 *            another summand
	 * @return the sum of the given numbers
	 */
	public double add(double summand1, double summand2) {
		return summand1 + summand2;
	}

	/**
	 * This method subtracts the second parameter (subtrahend) from the first parameter (minuend)
	 *
	 * @param minuend
	 *            the number of which the second parameter will be subtracted
	 * @param subtrahend
	 *            the number which will be subtracted from the first parameter
	 * @return the result of the subtraction
	 */
	public double subtract(double minuend, double subtrahend) {
		return add(minuend, subtrahend * -1);
	}

	/**
	 * This method multiply two double values.
	 *
	 * @param factor1
	 *            a factor
	 * @param factor2
	 *            another factor
	 * @return the result of the multiplication
	 */
	public double multiply(double factor1, double factor2) {
		return factor1 * factor2;
	}
}
