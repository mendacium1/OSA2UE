/**
 * Represents a compound circuit, which is a general circuit composed of other circuits.
 *
 * @author Jakob Mayr
 */
abstract class CompoundCircuit implements Circuit {

    protected Circuit circuit;

    /**
     * Constructs a CompoundCircuit object with the given circuit.
     *
     * @param circuit The circuit to be composed.
     */
    public CompoundCircuit(Circuit circuit) {
        this.circuit = circuit;
    }
}
