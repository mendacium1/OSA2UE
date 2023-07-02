package scanner;

import java.util.Scanner;

public class NumberInput {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int number = 0;
		do {
			System.out.print("Enter an integer: ");
			number = scanner.nextInt();
			System.out.println(number);
		} while (number > 0);

		scanner.close();
	}

}
