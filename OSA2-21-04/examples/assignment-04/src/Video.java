import java.math.BigDecimal;

public class Video extends Product {

	String genre;

	int runtimeInMinutes;

	/**
	 * Create a new video with the minimum information necessary.
	 *
	 * @param title title of the video
	 * @param price price of a single unit in €
	 */
	public Video(String title, BigDecimal price) {
		super(title, price);
	}

	/**
	 * Create a new video with all information which can be provided.
	 *
	 * @param title title of the video
	 * @param price price of a single unit in €
	 * @param genre the genre(s) which apply to this video
	 * @param runtimeInMinutes the total runtime in minutes
	 */
	public Video(String title, BigDecimal price, String genre, int runtimeInMinutes) {
		super(title, price);
		this.genre = genre;
		this.runtimeInMinutes = runtimeInMinutes;
	}

	public String getGenre() {
		return genre;
	}

	public int getRuntimeInMinutes() {
		return runtimeInMinutes;
	}

}
