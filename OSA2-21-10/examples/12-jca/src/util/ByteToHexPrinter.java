package util;

public class ByteToHexPrinter {

	public static void println(byte[] bytes) {
		for (byte b : bytes) {
			System.out.print(String.format("%02X ", b));
		}
		System.out.println();
	}

}
