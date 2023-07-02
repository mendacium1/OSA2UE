import java.util.Scanner;

public class Read {

	public static void main(String[] args) {

		System.out.print("Bitte geben Sie Ihren Namen ein: ");
		Scanner scanner = new Scanner(System.in);

		String name = scanner.next();

		System.out.println("Der eingegebene Name lautet " + name + ".\n");
		System.out.print("Bitte geben Sie eine ganze Zahl ein: ");

		int number = scanner.nextInt();
		System.out.println("Die eingegebene Zahl lautet " + number + ".");

		scanner.close();
	}

}
