import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AlternatingDigitSumTest {

	Checksum checksumCalculator;

	@BeforeEach
	public void setup() {
		checksumCalculator = new AlternatingDigitSum();
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
	@CsvSource({ "1, -5", "2, 5", "11, -10", "99, -4", "12345, 9", "99999999, -16" })
	public void testChecksumWithNumberStrings(String input, int checksum) {
		assertEquals(checksum, checksumCalculator.checksum(input));
	}

	@ParameterizedTest
	@CsvSource({ "a, 2", "A, 1", "hallo, 2", "Hallo, 8", "Hallo Welt!, 7" })
	public void testChecksumWithAlphanumericalStrings(String input, int checksum) {
		assertEquals(checksum, checksumCalculator.checksum(input));
	}
}
