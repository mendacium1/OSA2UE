
/**
 * This class implements the digit sum in order to generate a checksum.
 * <p>
 * The digit sum is calculated from the concatenated bytes representing the given input String. The individual digits
 * are added to each other in order to build the checksum.
 *
 * @author Claudia
 *
 */
public class DigitSum implements Checksum {

	/**
	 * This factor weighs each summand in the digit sum. The factor is always updated before it is applied with the
	 * method {@link #updateFactor()}.
	 */
	protected int factor;

	/**
	 * If the param <code>input</code> is <code>null</code> the checksum is <code>0</code>.
	 *
	 * @see Checksum#checksum(String)
	 *
	 */
	@Override
	public int checksum(String input) {
		init();

		int sum = 0;
		if (input != null) {
			char[] digits = buildDigitArray(input.getBytes());
			for (char c : digits) {
				sum += buildSummand(c);
			}
		}
		return sum;
	}

	/**
	 * Override this method set the initial value of the factor applied to the summand before adding them up.
	 * <p>
	 * By default, the factor is initialized with 1.
	 */
	protected void init() {
		factor = 1;
	}

	private char[] buildDigitArray(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for (byte b : bytes) {
			builder.append(b);
		}
		return builder.toString().toCharArray();
	}

	private int buildSummand(char c) {
		return Character.getNumericValue(c) * factor();
	}

	private int factor() {
		updateFactor();
		return factor;
	}

	/**
	 * Override this method in order to manipulate the factor which is applied to the summand <b>before</b> adding up
	 * each time a digit is added.
	 * <p>
	 * By default, the factor is not changed.
	 */
	protected void updateFactor() {
		// noop
	}

}
