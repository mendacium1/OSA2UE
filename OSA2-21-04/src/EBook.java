/**
 * The EBook class is a subclass of the Book class that represents an electronic version of a book.
 * It adds the format (e.g., PDF, EPUB, MOBI) in which it is stored to the Book class.
 * @author Jakob MAyr
 */
public class EBook extends Book {

    private String format = "";

    /**
     * Constructs a new EBook object with the given title and price.
     * @param title the title of the EBook
     * @param price the price of the EBook
     */
    public EBook(String title, float price) {
        super(title, price);
    }

    /**
     * Constructs a new EBook object with the given title, publisher, author, page count, price, and format.
     * @param title the title of the EBook
     * @param publisher the publisher of the EBook
     * @param author the author of the EBook
     * @param pageCount the number of pages in the EBook
     * @param price the price of the EBook
     *@param format the format of the EBook
     */
    public EBook(String title, String publisher, String author, int pageCount, float price, String format) {
        super(title, publisher, author, pageCount, price);
        this.format = format;
    }

    public String getFormat() {
        return this.format;
    }

}
