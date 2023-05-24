/**
 * Represents a circuit.
 *
 * @author Jakob Mayr
 */
public interface Circuit {

    /**
     * Returns the total resistance of the circuit.
     *
     * @return The resistance of the circuit.
     */
    double getOhm();

    /**
     * Returns the number of resistors in the circuit.
     *
     * @return The number of resistors.
     */
    int numberOfResistors();
}
