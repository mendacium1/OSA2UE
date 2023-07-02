
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DigitSumTest {

	Checksum checksumCalculator;

	@BeforeEach
	public void setup() {
		checksumCalculator = new DigitSum();
	}

	@Test
	public void testChecksumWithNull() {
		assertEquals(0, checksumCalculator.checksum(null));
	}

	@Test
	public void testChecksumWithBlank() {
		assertEquals(0, checksumCalculator.checksum(""));
	}

	@ParameterizedTest
	@CsvSource({ "1, 13", "2, 5", "11, 26", "99, 24", "12345, 39", "99999999, 96" })
	public void testChecksumWithNumberStrings(String input, int checksum) {
		assertEquals(checksum, checksumCalculator.checksum(input));
	}

	@ParameterizedTest
	@CsvSource({ "a, 16", "A, 11", "hallo, 42", "Hallo, 46", "Hallo Welt!, 91" })
	public void testChecksumWithAlphanumericalStrings(String input, int checksum) {
		assertEquals(checksum, checksumCalculator.checksum(input));
	}

}
