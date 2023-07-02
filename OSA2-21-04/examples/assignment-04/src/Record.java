import java.math.BigDecimal;

/**
 * Represents a record in a webshop.
 */
public class Record extends Product {

	String label;

	String performer;

	int runtimeInMinutes;

	/**
	 * Create a new record with the minimum information necessary.
	 *
	 * @param title title of the record
	 * @param price price of a single unit in €
	 */
	public Record(String title, BigDecimal price) {
		super(title, price);
	}

	/**
	 * Create a new record with all information which can be provided.
	 *
	 * @param title title of the record
	 * @param price price of a single unit in €
	 * @param label name of the record label
	 * @param performer name (or names) of the performer
	 * @param runtimeInMinutes total runtime in minutes
	 */
	public Record(String title, BigDecimal price, String label, String performer, int runtimeInMinutes) {
		super(title, price);
		this.label = label;
		this.performer = performer;
		this.runtimeInMinutes = runtimeInMinutes;
	}

	public String getLabel() {
		return label;
	}

	public String getPerformer() {
		return performer;
	}

	public int getRuntimeInMinutes() {
		return runtimeInMinutes;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + performer + " - " + title + " (" + price + ")";
	}
}
