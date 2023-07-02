import java.math.BigDecimal;

/**
 * Represents books in a webshop.
 */
public class Book extends Product {

	String publisher;
	String author;
	int nrOfPages;

	/**
	 * Create a new book with the minimum information necessary.
	 *
	 * @param title title of the book
	 * @param price price of a single unit in €
	 */
	public Book(String title, BigDecimal price) {
		super(title, price);
	}

	/**
	 * Create a new book with all information which can be provided.
	 *
	 * @param title title of the product
	 * @param price price of a single unit in €
	 * @param publisher name (or names) of the publisher
	 * @param author name (or names) of the authors
	 * @param nrOfPages the number of pages
	 */
	public Book(String title, BigDecimal price, String publisher, String author, int nrOfPages) {
		super(title, price);
		this.publisher = publisher;
		this.author = author;
		this.nrOfPages = nrOfPages;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getAuthor() {
		return author;
	}

	public int getNrOfPages() {
		return nrOfPages;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + author + " - " + title + " (" + price + ")";
	}
}
