/**
 * Represents a parallel circuit, which combines multiple circuits in parallel.
 *
 * @author Jakob Mayr
 */
class Parallel extends CompoundCircuit {
    private final Circuit additionalCircuit;

    /**
     * Constructs a Parallel object with the given circuits in parallel.
     *
     * @param circuit           The first circuit in parallel.
     * @param additionalCircuit The additional circuit to be added in parallel.
     */
    public Parallel(Circuit circuit, Circuit additionalCircuit) {
        super(circuit);
        this.additionalCircuit = additionalCircuit;
    }

    /**
     * Returns the total resistance of the parallel circuit.
     * The total resistance is calculated using the formula: 1 / (1/R1 + 1/R2 + ... + 1/Rn),
     * where R1, R2, ..., Rn are the resistances of the individual circuits in parallel.
     *
     * @return The total resistance of the parallel circuit.
     */
    @Override
    public double getOhm() {
        return 1 / ((1 / circuit.getOhm()) + (1 / additionalCircuit.getOhm()));
    }

    /**
     * Returns the total number of resistors in the parallel circuit.
     * The total number of resistors is the sum of the number of resistors in the individual circuits.
     *
     * @return The total number of resistors in the parallel circuit.
     */
    @Override
    public int numberOfResistors() {
        return circuit.numberOfResistors() + additionalCircuit.numberOfResistors();
    }
}
