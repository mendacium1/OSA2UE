
/**
 * This class calculates an alternating digit sum in order to generate a checksum.
 * <p>
 * The alternating digit sum basically works like the digit sum. The difference is that the individual digits are taken
 * in turn at adding and subtracting.
 *
 * @author Claudia
 *
 */
public class AlternatingDigitSum extends DigitSum {

	/**
	 * Multiply the factor with -1 in order to alternate adding and subtracting.
	 *
	 * @see DigitSum#updateFactor()
	 */
	@Override
	protected void updateFactor() {
		factor *= -1;
	}

	/**
	 * Initialize the factor with -1.
	 *
	 * @see DigitSum#init()
	 */
	@Override
	protected void init() {
		factor = -1;
	}

}
