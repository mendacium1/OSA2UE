/**
 * The CartItem class represents an item and its quantity in a shopping cart.
 * @author Jakob Mayr
 */
public class CartItem {

    private Product product;
    private int quantity;

    /**
     * Constructs a new CartItem object with the given product and quantity.
     * @param product the product to add to the cart
     * @param quantity the quantity of the item to add to the cart
     */
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getItem() {
        return this.product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Generate a string for the item with quantity and total price.
     * @return the string of the Item together with the quantity and the total price
     */
    @Override
    public String toString() {
        return this.getItem().toString() + " [ Qty " + this.getQuantity() + " ] - " +
                this.getQuantity() * this.getItem().getPrice();
    }
}