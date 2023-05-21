/**
 * The Item class represents a product with a title and a price.
 *
 * It implements the Product interface.
 * @author Jakob Mayr
 */
public class Item implements Product {

    private String title = "";
    private float price = 0;

    /**
     * Constructs an Item object with a given title and price.
     * @param title the title of the item.
     * @param price the price of the item.
     */
    public Item(String title, float price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public float getPrice() {
        return this.price;
    }


    /**
     * Returns a string representation of the Item object.
     * @return a string representation of the Item object in the format "Book: title (price)"
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + this.title + '(' + this.price + ')';
    }
}

