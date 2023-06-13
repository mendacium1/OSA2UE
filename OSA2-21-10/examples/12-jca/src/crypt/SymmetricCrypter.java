package crypt;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import util.ByteToHexPrinter;

public class SymmetricCrypter {

	public static void main(String[] args) throws Exception {
		SymmetricCrypter crypter = new SymmetricCrypter();

		// Gunkls Tip des Tages vom 16.12.2000, http://www.gunkl.at
		String plaintext = "Vermeiden Sie heute den Satz \"So wird das nichts!\".";
		byte[] crypttext = crypter.encrypt(plaintext);

		ByteToHexPrinter.println(crypttext);
		System.out.println(crypter.decrypt(crypttext));

	}

	private static final String ALGORITHM = "AES";
	private static final String CIPHER = "AES/CBC/PKCS5PADDING";

	private byte[] key;
	private byte[] initVector;

	private IvParameterSpec iv;
	private SecretKeySpec keySpec;

	public SymmetricCrypter() {
		SecureRandom random = new SecureRandom();

		key = new byte[16];
		random.nextBytes(key);

		initVector = new byte[16];
		random.nextBytes(initVector);

		iv = new IvParameterSpec(initVector);
		keySpec = new SecretKeySpec(key, ALGORITHM);
	}

	private byte[] encrypt(final String plaintext) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

		Cipher cipher = Cipher.getInstance(CIPHER);
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);

		return cipher.doFinal(plaintext.getBytes());
	}

	private String decrypt(final byte[] crypttext) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

		Cipher cipher = Cipher.getInstance(CIPHER);
		cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);

		byte[] decoded = cipher.doFinal(crypttext);

		return new String(decoded);
	}
}
