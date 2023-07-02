import java.math.BigDecimal;

/**
 * <p>Abstract base class for products in a webshop.</p>
 * <p>All products in the webshop must have the following properties:
 * <ul>
 *     <li>name</li>
 *     <li>price</li>
 * </ul>
 * </p>
 */
public abstract class Product {
	String title;
	BigDecimal price;

	/**
	 * Create a new product with the minimum information necessary.
	 *
	 * @param title title of the product
	 * @param price price of a single unit in €
	 */
	public Product(String title, BigDecimal price) {
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + title + " (" + price + ")";
	}
}
