import java.math.BigDecimal;

public class WebshopTest {

	public static void main(String[] args) {
		Product p1 = new Book("Weniger Schlecht Programmieren", new BigDecimal("19.99"), "O'Reilly", "Kathrin Passig & Johannes Jander", 300);
		Product p2 = new EBook("Weniger Schlecht Programmieren", new BigDecimal("19.99"), "O'Reilly", "Kathrin Passig & Johannes Jander", 300, "epub");
		Product p3 = new Record("Dark Side of the Moon", new BigDecimal("17.14"), "Parlophone Label Group", "Pink Floyd", 43);
		Product p4 = new Video("Die Ritter der Kokosnuss", new BigDecimal("8.05"), "Comedy", 86);

		Cart cart = new Cart();

		System.out.println(cart.toString());
		System.out.println();

		cart.addItem(p1, 1);
		cart.addItem(p3, 2);

		System.out.println(cart.toString());
		System.out.println();

		cart.reset();

		System.out.println(cart.toString());
		System.out.println();

		cart.addItem(p2, 3);
		cart.addItem(p1, 1);
		cart.addItem(p4, 1);

		System.out.println(cart.toString());
	}
}
