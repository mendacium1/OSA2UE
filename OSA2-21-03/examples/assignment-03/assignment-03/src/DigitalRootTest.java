
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DigitalRootTest {

	Checksum checksumCalculator;

	@BeforeEach
	public void setup() {
		checksumCalculator = new DigitalRoot();
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
	@CsvSource({ "1, 4", "2, 5", "11, 8", "99, 6", "12345, 3", "99999999, 6" })
	public void testChecksumWithNumberStrings(String input, int checksum) {
		assertEquals(checksum, checksumCalculator.checksum(input));
	}

	@ParameterizedTest
	@CsvSource({ "a, 7", "A, 2", "hallo, 6", "Hallo, 1", "Hallo Welt!, 1" })
	public void testChecksumWithAlphanumericalStrings(String input, int checksum) {
		assertEquals(checksum, checksumCalculator.checksum(input));
	}

}
