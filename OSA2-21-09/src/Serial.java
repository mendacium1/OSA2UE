/**
 * Represents a series circuit, which combines multiple circuits in series.
 *
 * @author Jakob Mayr
 */
class Serial extends CompoundCircuit {

    private final Circuit additionalCircuit;

    /**
     * Constructs a Serial object with the given circuits in series.
     *
     * @param circuit           The first circuit in the series.
     * @param additionalCircuit The additional circuit to be added in series.
     */
    public Serial(Circuit circuit, Circuit additionalCircuit) {
        super(circuit);
        this.additionalCircuit = additionalCircuit;
    }

    /**
     * Returns the total resistance of the series circuit.
     * The total resistance is the sum of the resistances of the individual circuits in series.
     *
     * @return The total resistance of the series circuit.
     */
    @Override
    public double getOhm() {
        return circuit.getOhm() + additionalCircuit.getOhm();
    }

    /**
     * Returns the total number of resistors in the series circuit.
     * The total number of resistors is the sum of the number of resistors in the individual circuits.
     *
     * @return The total number of resistors in the series circuit.
     */
    @Override
    public int numberOfResistors() {
        return circuit.numberOfResistors() + additionalCircuit.numberOfResistors();
    }
}
