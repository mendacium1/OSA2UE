/**
 * The Video class represents a video item with a title, genre, runtime and price.
 * It is a subclass of the Item class.
 * @author Jakob Mayr
 */
public class Video extends Item {

    private String genre = "";
    private int runtime = 0;

    /**
     * Constructs a Video object with the specified title and price.
     * @param title the title of the video
     * @param price the price of the video
     */
    public Video(String title, float price) {
        super(title, price);
    }

    /**
     * Constructs a Video object with the specified title, genre, runtime and price.
     * @param title the title of the video
     * @param genre the genre of the video
     * @param runtime the runtime of the video in minutes
     * @param price the price of the video
     */
    public Video(String title, String genre, int runtime, float price) {
        super(title, price);
        this.genre = genre;
        this.runtime = runtime;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getRuntime() {
        return this.runtime;
    }

}