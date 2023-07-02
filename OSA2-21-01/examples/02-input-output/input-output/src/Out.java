import java.util.Arrays;

public class Out {
	public static void main(String[] args) {
		String letters = "ABC";
		char[] numbers = { '1', '2', '3' };
		System.out.print(letters + " easy as " + numbers[0]);

		System.out.println();

		print();
		format();

	}

	public static void print() {
		System.out.println("Eine Zeile.");

		System.out.println();

		System.out.print("Jetzt gibt es keinen ");
		System.out.print("Zeilenumbruch. ");
		System.out.println("Aber jetzt.");

		System.out.println(1);
		System.out.println(2.0);
		System.out.println('3');

		System.out.println();

		System.err.println("Irren ist menschlich...");
	}

	public static void format() {
		System.out.printf("Mein Name ist \"%s\" und ich komme aus %s.", "Donald", "Entenhausen");

		System.out.println();

		int i = 123;
		System.out.printf("|%d| |%d|%n", i, -i);
		System.out.printf("|%5d| |%5d|%n", i, -i);
		System.out.printf("|%-5d| |%-5d|%n", i, -i);
		System.out.printf("|%+-5d| |%+-5d|%n", i, -i);
		System.out.printf("|%05d| |%05d|%n", i, -i);

		double d = 12345.678;
		System.out.printf("|%f| |%f|%n", d, -d);
		System.out.printf("|%.2f| |%.2f|%n", d, -d);
		System.out.printf("|%,10f| |%,10f|%n", d, -d);
		// System.out.printf("|%d| |%d|%n", d, -d);
		System.out.printf("|%s| |%s|%n", d, -d);
		System.out.printf("|%e| |%e|%n", d, -d);
	}
}
