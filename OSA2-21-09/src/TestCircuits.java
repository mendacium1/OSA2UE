import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for the Circuit implementations.
 *
 * @author Jakob Mayr
 */
public class TestCircuits {

    /**
     * Test case for the first example circuit.
     * The expected total resistance is 155.905512 ohms.
     */
    @Test
    public void testFirstExampleCircuit() {
        Circuit firstExampleCircuit =
                new Parallel(new Resistor(600),
                        new Parallel(
                                new Serial(new Resistor(400), new Resistor(500)),
                                new Serial(
                                        new Parallel(new Resistor(100), new Resistor(300)),
                                        new Resistor(200)
                                )
                        )
                );

        double expectedResistance = 155.905512;
        double actualResistance = firstExampleCircuit.getOhm();

        Assert.assertEquals(expectedResistance, actualResistance, 0.01);
    }

    /**
     * Test case for the second example circuit.
     * The expected total resistance is 238.095238 ohms.
     */
    @Test
    public void testSecondExampleCircuit() {
        Circuit secondExampleCircuit =
                new Serial(
                        new Parallel(new Resistor(100), new Resistor(200)),
                        new Parallel(new Resistor(300), new Resistor(400))
                );

        double expectedResistance = 238.095238;
        double actualResistance = secondExampleCircuit.getOhm();

        Assert.assertEquals(expectedResistance, actualResistance, 0.01);
    }

    /**
     * Test case for the third example circuit.
     * The expected total resistance is 210 ohms.
     */
    @Test
    public void testThirdExampleCircuit() {
        Circuit thirdExampleCircuit =
                new Parallel(
                        new Serial(new Resistor(100), new Resistor(200)),
                        new Serial(new Resistor(300), new Resistor(400))
                );

        double expectedResistance = 210.0;
        double actualResistance = thirdExampleCircuit.getOhm();

        Assert.assertEquals(expectedResistance, actualResistance, 0.01);
    }
}
