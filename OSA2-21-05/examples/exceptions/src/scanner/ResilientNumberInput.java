package scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ResilientNumberInput {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int number = 0;
		do {
			try {
				System.out.print("Enter an integer: ");
				number = scanner.nextInt();
				System.out.println(number);
			} catch (InputMismatchException e) {
				System.err.println("Invalid integer!");
				scanner.nextLine();
			}
		} while (number > 0);

		scanner.close();
	}

}
