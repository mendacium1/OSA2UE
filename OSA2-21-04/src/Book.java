/**
 * The Book class is a subclass of the Item class that represents a book item in a store.
 * @author Jakob Mayr
 */
public class Book extends Item {

    private String publisher = "";
    private String author = "";
    private int pageCount = 0;

    /**
     * Constructs a new Book object with the given title and price.
     * @param title the title of the book
     * @param price the price of the book
     */
    public Book(String title, float price) {
        super(title, price);
    }

    /**
     * Constructs a new Book object with the given title, publisher, author, page count, and price.
     * @param title the title of the book
     * @param publisher the publisher of the book
     * @param author the author of the book
     * @param pageCount the number of pages in the book
     * @param price the price of the book
     */
    public Book(String title, String publisher, String author, int pageCount, float price) {
        super(title, price);
        this.publisher = publisher;
        this.author = author;
        this.pageCount = pageCount;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    /**
     * Returns a string representation of the Book object.
     * @return a string representation of the Book object in the format "Book: author - title (price)"
     */
    @Override
    public String toString() {
        return this.getClass().getName() + ": " + this.author + " - " + this.getTitle() + '(' + this.getPrice() + ')';
    }
}