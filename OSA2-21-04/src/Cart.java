/**
 * A class representing a shopping cart that can store up to 10 items.
 * @author Jakob Mayr
 */
public class Cart {

    private static final int MAX_ITEMS = 10;
    private CartItem items[] = new CartItem[MAX_ITEMS];
    int itemCount;

    /**
     * Constructs an empty shopping cart.
     */
    public Cart() {
        this.itemCount = 0;
    }

    /**
     * Adds a CartItem to the cart with the specified quantity.
     * Prints an Error-message if the cart is full (10 items max).
     * @param item the CartItem to add to the cart
     * @param quantity the quantity of the item to add to the cart
     * @return true if the item was added successfully, false otherwise
     */
    public boolean addItem(CartItem item, int quantity) {
        if (this.itemCount >= MAX_ITEMS) {
            System.err.println("Cart is full! No more than 10 items allowed!");
            return false;
        }
        this.items[itemCount] = item;
        this.itemCount++;
        return true;
    }

    /**
     * Calculates and returns the total cost of all items in the cart.
     * @return the total cost of all items in the cart
     */
    public float getOrderTotal() {
        float total = 0;
        for (int i = 0; i < this.itemCount; i++) {
            total += this.items[i].getItem().getPrice() * this.items[i].getQuantity();
        }
        return total;
    }

    /**
     * Resets the cart by removing all items from it.
     * @return true if the cart was reset successfully, false otherwise
     */
    public boolean reset() {
        if (this.itemCount >= MAX_ITEMS) {
            return false;
        }
        this.itemCount = 0;
        return true;
    }

    /**
     * Returns a string representation of the Cart object.
     * @return a string containing the contents of the cart and the total cost
     */
    @Override
    public String toString() {
        String output = "Cart Contents\n";
        for (int i = 0; i < this.itemCount; i++) {
                output += this.items[i].toString() + "\n";
        }
        output += "Total: " + this.getOrderTotal();
        return output;
    }
}