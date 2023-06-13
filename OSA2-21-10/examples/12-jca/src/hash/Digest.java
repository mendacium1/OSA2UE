package hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import util.ByteToHexPrinter;

public class Digest {

	public static void main(String[] args) throws NoSuchAlgorithmException {

		// Gunkls Tip des Tages vom 17.08.2004, http://www.gunkl.at
		String input = "Gerade vorhin ist mein Computer abgestürzt, was grundsätzlich nicht weiter erwähnenswert ist, "
				+ "da bin ich nachsichtig, schließlich wüßte ich ohnehin nicht, wie ich sozusagen zu Fuß einen der "
				+ "Datenträger auf Konsistenz überprüfen sollte, das macht der Rechner dann jeweils beim Hochfahren "
				+ "selbst, aber er hat mir dann eine Meldung auf den Bildschirm gestellt, irgend ein Programm hat "
				+ "irgend welche weißichnicht-Applikationen oder so was nicht gekriegt, oder geholt, ich hab mir den "
				+ "vollen Text nicht durchgelesen, weil als Möglichkeit für mich, auf diese Meldung zu reagieren, "
				+ "hat mir der Rechner nur das rote Kreuzchen am rechten oberen Rand des Fensterchens und ein \"Cancel\" "
				+ "angeboten. Wenn nur eine Antwort möglich ist, muß ich die Frage nicht verstehen.";

		digest(input, "MD5");
		digest(input, "MD5");
		digest(input, "SHA-1");
		digest(input, "SHA-512");
		digest(input, "SHA3-512");
	}

	public static void digest(final String input, final String algorithm) throws NoSuchAlgorithmException {
		MessageDigest digester = MessageDigest.getInstance(algorithm);
		digester.update(input.getBytes());
		byte[] digest = digester.digest();

		ByteToHexPrinter.println(digest);
	}
}
