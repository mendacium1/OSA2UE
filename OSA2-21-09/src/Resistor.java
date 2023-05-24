/**
 * Represents a resistor circuit component.
 *
 * @author Jakob Mayr
 */
public class Resistor implements Circuit {

    private final int resistance;

    /**
     * Constructs a Resistor object with the given resistance.
     *
     * @param resistance The resistance value of the resistor.
     */
    public Resistor(int resistance) {
        this.resistance = resistance;
    }

    /**
     * Returns the resistance value of the resistor.
     *
     * @return The resistance value.
     */
    @Override
    public double getOhm() {
        return this.resistance;
    }

    /**
     * Returns the number of resistors in the circuit, which is always 1 for a single resistor.
     *
     * @return The number of resistors (always 1).
     */
    @Override
    public int numberOfResistors() {
        return 1;
    }
}
