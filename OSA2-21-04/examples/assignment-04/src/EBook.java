import java.math.BigDecimal;

/**
 * Represents an eBook in a webshop.
 */
public class EBook extends Book {

	String format;

	/**
	 * Create a new eBook with the minimum information necessary.
	 *
	 * @param title title of the eBook
	 * @param price price of a single unit in €
	 */
	public EBook(String title, BigDecimal price) {
		super(title, price);
	}

	/**
	 * Create a new eBook with all information which can be provided.
	 *
	 * @param title title of the eBook
	 * @param price price of a single unit in €
	 * @param publisher name (or names) of the publisher
	 * @param author name (or names) of the authors
	 * @param nrOfPages the number of pages
	 * @param format the eBook format (epub, mobi, pdf)
	 */
	public EBook(String title, BigDecimal price, String publisher, String author, int nrOfPages, String format) {
		super(title, price, publisher, author, nrOfPages);
		this.format = format;
	}
}
