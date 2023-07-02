package random;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class RandomThings {

	public static void main(String[] args) throws NoSuchAlgorithmException {

		repeat();
		System.out.println();

		seeded();
		System.out.println();

		secure();
	}

	private static void repeat() {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			System.out.println(random.nextInt());
		}
		System.out.println();
		for (int i = 0; i < 10; i++) {
			System.out.println(random.nextInt(10));
		}
	}

	private static void seeded() {
		for (int i = 0; i < 10; i++) {
			Random random = new Random();
			Random seededRandom = new Random(1000);
			System.out.println(random.nextInt(10) + " | " + seededRandom.nextInt(10));
		}
	}

	private static void secure() throws NoSuchAlgorithmException {
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		for (int i = 0; i < 10; i++) {
			System.out.println(random.nextInt());
		}
	}
}
