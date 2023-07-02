import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * <p>Represents a singly entry in a {@link Cart}.</p>
 * <p>Every item consits of:
 * <ul>
 *     <li>a {@link Product} and a</li>
 *     <li>quantity</li>
 * </ul></p>
 */
public class CartItem {

	Product product;
	int quantity;

	/**
	 * Create a new cart item.
	 *
	 * @param product the product to be added to the cart
	 * @param quantity the number of the given product which will be bought
	 */
	public CartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	/**
	 * @return the order sum for this cart item
	 */
	BigDecimal getItemSum() {
		return product.getPrice().multiply(BigDecimal.valueOf(quantity));
	}

	@Override
	public String toString() {
		return product + " [ Qty " + quantity + " ] - " + getItemSum();
	}
}
