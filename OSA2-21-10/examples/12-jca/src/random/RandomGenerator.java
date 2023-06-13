package random;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class RandomGenerator {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		for (int i = 0; i < 10; i++) {
			Random unsecureRandom = new Random();
			System.out.println("Some random number: " + unsecureRandom.nextInt());
		}

		for (int i = 0; i < 10; i++) {
			Random seededRandom = new Random(1L);
			System.out.println("Some random number from a seed: " + seededRandom.nextInt());
		}

		for (int i = 0; i < 10; i++) {
			// list of available algorithms:
			// https://docs.oracle.com/en/java/javase/16/security/oracle-providers.html#GUID-9DC4ADD5-6D01-4B2E-9E85-B88E3BEE7453
			Random secureRandom = SecureRandom.getInstance("SHA1PRNG");
			System.out.println("Some more secure random number: " + secureRandom.nextInt());
		}

	}

}
