import java.math.BigDecimal;

/**
 * <p>Represents a shopping cart in a webshop.</p>
 * <p>A shopping cart consists of multiple {@link CartItem}s.</p>
 */
public class Cart {

	static final int MAX_NR_OF_ITEMS = 10;
	CartItem[] items;
	int indexOfNextItem;

	/**
	 * <p>Create an empty shopping cart.</p>
	 * <p>The maximum capacity of the cart is {@value MAX_NR_OF_ITEMS}.</p>
	 */
	public Cart() {
		reset();
	}

	/**
	 * Reset the shopping cart.
	 * <p>This will remove all previously added items from the cart.</p>
	 * <p><strong>CAUTION:</strong> This is not reversible! All previous cart items are lost after resetting.</p>
	 */
	void reset() {
		items = new CartItem[MAX_NR_OF_ITEMS];
		indexOfNextItem = 0;
	}

	/**
	 * Add a new item with a given quantity to the cart.
	 *
	 * @param product the product to be added to the cart
	 * @param quantity the number of the given product which will be bought
	 */
	public void addItem(Product product, int quantity) {
		if (indexOfNextItem < MAX_NR_OF_ITEMS) {
			items[indexOfNextItem++] = new CartItem(product, quantity);
		} else {
			System.out.println("Maximale Anzahl von Einträgen im Warenkorb erreicht. Produkt kann nicht mehr hinzugefügt werden.");
		}
	}

	/**
	 * @return the total sum of all cart items in this cart
	 */
	public BigDecimal getOrderTotal() {
		BigDecimal total = BigDecimal.ZERO;

		for (int i = 0; i < indexOfNextItem; i++) {
			total = total.add(items[i].getItemSum());
		}

		return total;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Cart Contents").append("\n");
		for (int i = 0; i < indexOfNextItem; i++) {
			CartItem item = items[i];
			builder.append(item).append("\n");
		}

		builder.append("Total: ").append(getOrderTotal());
		return builder.toString();
	}
}
