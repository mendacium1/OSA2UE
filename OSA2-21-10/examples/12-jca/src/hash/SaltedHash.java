package hash;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import util.ByteToHexPrinter;

public class SaltedHash {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {

		// Gunkls Tip des Tages vom 03.09.2004, http://www.gunkl.at
		String password = "Der Zweck ist das Ziel.";

		saltedhash(password, "salt");
		saltedhash(password, "salt");

		saltedhash(password, "pepper");

	}

	private static void saltedhash(final String password, final String salt)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 32, 512);

		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");

		byte[] hash = factory.generateSecret(spec).getEncoded();

		ByteToHexPrinter.println(hash);
	}

}
