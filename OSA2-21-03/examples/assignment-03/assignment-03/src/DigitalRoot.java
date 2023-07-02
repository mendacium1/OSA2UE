

/**
 * This class calculates the digital root in order to generate a checksum.
 * <p>
 * The digital root is a refinement of the digit sum in the super class. It
 * calculates the digit sum. When the result has more than 1 digit and
 * calculates the digit sum for the result. This is repeated until we get a
 * one digit result.
 *
 * @author Claudia
 *
 */
public class DigitalRoot extends DigitSum implements Checksum {

	/**
	 * @see DigitSum#checksum(String)
	 */
	@Override
	public int checksum(String input) {
		int checksum = super.checksum(input);
		while (checksum > 9) {
			checksum = digitSum(checksum);
		}

		return checksum;
	}

	private int digitSum(int i) {
		int sum = 0;
		while (i > 0) {
			sum += i % 10;
			i /= 10;
		}
		return sum;
	}
}
