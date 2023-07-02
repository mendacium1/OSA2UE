public class Wrappers {

	public static void main(String[] args) {
		System.out.println("Wrapper Classes in Java");
		System.out.println();

		showByteWrapper();
		showShortWrapper();
		showIntegerWrapper();
		showLongWrapper();
		showFloatWrapper();
		showDoubleWrapper();

		showBooleanWrapper();

		showCharacterWrapper();
	}

	private static void showByteWrapper() {
		System.out.println(Byte.class.getCanonicalName());

		System.out.println("Bits: " + Byte.SIZE);
		System.out.println("Bytes: " + Byte.BYTES);
		System.out.println("Min: " + Byte.MIN_VALUE);
		System.out.println("Max: " + Byte.MAX_VALUE);

		System.out.println();
	}

	private static void showShortWrapper() {
		System.out.println(Short.class.getCanonicalName());

		System.out.println("Bits: " + Short.SIZE);
		System.out.println("Bytes: " + Short.BYTES);
		System.out.println("Min: " + Short.MIN_VALUE);
		System.out.println("Max: " + Short.MAX_VALUE);

		System.out.println();
	}

	private static void showIntegerWrapper() {
		System.out.println(Integer.class.getCanonicalName());

		System.out.println("Bits: " + Integer.SIZE);
		System.out.println("Bytes: " + Integer.BYTES);
		System.out.println("Min: " + Integer.MIN_VALUE);
		System.out.println("Max: " + Integer.MAX_VALUE);

		System.out.println();
	}

	private static void showLongWrapper() {
		System.out.println(Long.class.getCanonicalName());

		System.out.println("Bits: " + Long.SIZE);
		System.out.println("Bytes: " + Long.BYTES);
		System.out.println("Min: " + Long.MIN_VALUE);
		System.out.println("Max: " + Long.MAX_VALUE);

		System.out.println();
	}

	private static void showFloatWrapper() {
		System.out.println(Float.class.getCanonicalName());

		System.out.println("Bits: " + Float.SIZE);
		System.out.println("Bytes: " + Float.BYTES);
		System.out.println("Min Value: " + Float.MIN_VALUE);
		System.out.println("Min Exponent: " + Float.MIN_VALUE);
		System.out.println("Max Value: " + Float.MAX_VALUE);
		System.out.println("Max Exponent: " + Float.MAX_EXPONENT);
		System.out.println("Negative Infinity: " + Float.NEGATIVE_INFINITY);
		System.out.println("Positive Infinity: " + Float.POSITIVE_INFINITY);
		System.out.println("NaN: " + Float.NaN);

		System.out.println();
	}

	private static void showDoubleWrapper() {
		System.out.println(Double.class.getCanonicalName());

		System.out.println("Bits: " + Double.SIZE);
		System.out.println("Bytes: " + Double.BYTES);
		System.out.println("Min Value: " + Double.MIN_VALUE);
		System.out.println("Min Exponent: " + Double.MIN_VALUE);
		System.out.println("Max Value: " + Double.MAX_VALUE);
		System.out.println("Max Exponent: " + Double.MAX_EXPONENT);
		System.out.println("Negative Infinity: " + Double.NEGATIVE_INFINITY);
		System.out.println("Positive Infinity: " + Double.POSITIVE_INFINITY);
		System.out.println("NaN: " + Double.NaN);

		System.out.println();
	}

	private static void showBooleanWrapper() {
		System.out.println(Boolean.class.getCanonicalName());

		System.out.println("True: " + Boolean.TRUE);
		System.out.println("False: " + Boolean.FALSE);

		System.out.println();
	}

	private static void showCharacterWrapper() {
		System.out.println(Character.class.getCanonicalName());

		System.out.println("Bits: " + Character.SIZE);
		System.out.println("Bytes: " + Character.BYTES);
		System.out.printf("Min: \\u%1$04x (%1$d)%n", (int) Character.MIN_VALUE);
		System.out.printf("Max: \\u%1$04x (%1$d)%n", (int) Character.MAX_VALUE);

		System.out.println();
	}
}
