/**
 * Implementing classes offer a method for the calculation of checksums.
 *
 * @author Claudia
 *
 */
public interface Checksum {

	/**
	 * Calculate a checksum for the given input.
	 * <p>
	 * A checksum can be used to detect the integrity of a given input. Normally the checksum is provided with the
	 * original content. The recipient than also calculates the checksum for the content submitted. If the two checksums
	 * differ there was some mistake during the transmission.
	 *
	 * @param input
	 *            the input string of which the checksum should be calculated
	 * @return the integer checksum
	 */
	int checksum(String input);

}
