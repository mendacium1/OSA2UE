import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnitTest {

	@BeforeAll
	static void setupAll() {
		System.out.println("@BeforeAll");
	}

	@AfterAll
	static void cleanupAll() {
		System.out.println("@AfterAll");
	}

	@BeforeEach
	void setup() {
		System.out.println("@BeforeEach");
	}

	@AfterEach
	void cleanup() {
		System.out.println("@AfterEach");
	}

	@Test
	void testSuccess() {
		System.out.println("@Test testSuccess");
		assertTrue(true);
	}

	@Test
	void testFailure() {
		System.out.println("@Test testFailure");
		fail("Not yet implemented");
	}

}
