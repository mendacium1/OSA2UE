/**
 * The SoundCarrier class is a subclass of the Item class that represents a sound carrier (e.g., CD, vinyl record).
 * It adds a label, interpreter, and runtime (in minutes) to the Item class.
 * @author Jakob Mayr
 */
public class SoundCarrier extends Item {
    String label = "";
    String interpreter = "";
    int runtime = 0;

    /**
     * Constructs a new SoundCarrier object with the given title and price.
     * @param title the title of the sound carrier
     * @param price the price of the sound carrier
     */
    public SoundCarrier(String title, float price) {
        super(title, price);
    }

    /**
     * Constructs a new SoundCarrier object with the given title, price, label, interpreter, and runtime.
     * @param title the title of the sound carrier
     * @param price the price of the sound carrier
     * @param label the label of the sound carrier
     * @param interpreter the interpreter of the sound carrier
     * @param runtime the runtime (in minutes) of the sound carrier
     */
    public SoundCarrier(String title, float price, String label, String interpreter, int runtime) {
        super(title, price);
        this.label = label;
        this.interpreter = interpreter;
        this.runtime = runtime;
    }

    public String getLabel() {
        return label;
    }

    public String getInterpreter() {
        return interpreter;
    }

    public int getRuntime() {
        return runtime;
    }

    /**
     * Returns a string representation of the SoundCarrier object.
     * @return a string representation of the SoundCarrier object
     */
    @Override
    public String toString() {
        return this.getClass().getName() + ": " + this.interpreter + " - " + this.getTitle() + '(' + this.getPrice() + ')';
    }
}
