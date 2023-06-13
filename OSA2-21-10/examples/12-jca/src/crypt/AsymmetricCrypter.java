package crypt;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import util.ByteToHexPrinter;

public class AsymmetricCrypter {

	public static void main(String[] args) throws Exception {
		AsymmetricCrypter alice = new AsymmetricCrypter();
		AsymmetricCrypter bob = new AsymmetricCrypter();

		// Gunkls Tip des Tages vom 27.07.2000, http://www.gunkl.at
		String plaintext = "Was Du morgen kannst verschieben, ist seit gestern Dir geblieben.";

		Message message = alice.encrypt(plaintext, bob.publicKey());

		ByteToHexPrinter.println(message.payload);
		ByteToHexPrinter.println(message.signature);

		System.out.println(bob.decrypt(message, alice.publicKey()));
	}

	private static final String ALGORITHM = "RSA";
	private static final String CIPHER = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
	private static final String SIGNATURE = "SHA256withRSA";

	private KeyPair keyPair;

	public AsymmetricCrypter() throws NoSuchAlgorithmException {
		KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITHM);
		generator.initialize(2048);
		keyPair = generator.generateKeyPair();
	}

	public PublicKey publicKey() {
		return keyPair.getPublic();
	}

	private Message encrypt(final String plaintext, final PublicKey otherkey)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, SignatureException {

		Cipher cipher = Cipher.getInstance(CIPHER);
		cipher.init(Cipher.ENCRYPT_MODE, otherkey);

		byte[] original = plaintext.getBytes();
		byte[] encoded = cipher.doFinal(original);

		Signature signer = Signature.getInstance(SIGNATURE);
		signer.initSign(keyPair.getPrivate());
		signer.update(original);
		byte[] signature = signer.sign();

		return new Message(encoded, signature);
	}

	private String decrypt(final Message message, final PublicKey otherkey)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, SignatureException {

		Cipher cipher = Cipher.getInstance(CIPHER);
		cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());

		byte[] decoded = cipher.doFinal(message.payload);

		Signature signer = Signature.getInstance(SIGNATURE);
		signer.initVerify(otherkey);
		signer.update(decoded);
		if (!signer.verify(message.signature)) {
			throw new IllegalStateException("Signature does not match.");
		}

		return new String(decoded);
	}

}

class Message {
	byte[] payload;
	byte[] signature;

	Message(byte[] payload, byte[] signature) {
		this.payload = payload;
		this.signature = signature;
	}
}