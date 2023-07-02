import java.math.BigDecimal;

public class FuzzyArithmetics {

	public static void main(String[] args) {
		System.err.println(2.00 - 1.10);

		alternative1();
		alternative2();
		alternative3();
	}

	static void alternative1() {
		System.out.printf("%.2f%n", 2.00 - 1.10);
	}

	static void alternative2() {
		System.out.println(200 - 110);
		System.out.println((200 - 110) / 100.0);
	}

	static void alternative3() {
		System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
	}
}
