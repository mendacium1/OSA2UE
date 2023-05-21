import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test class for the ArrayUtil class.
 *
 * @author Jakob Mayr
 */
public class ArrayUtilTest {

    /**
     * Tests the getMax method with an input array of positive and negative integers.
     */
    @Test
    public void testGetMax() {
        Integer[] posIntArray = {5, 3, 8, 2, 10};
        Assertions.assertEquals(10, ArrayUtil.getMax(posIntArray));

        Integer[] negIntArray = {-5, -3, -8, -2, -10};
        Assertions.assertEquals(-2, ArrayUtil.getMax(negIntArray));
    }

    /**
     * Tests the getMax method with a null input array and expects a NullPointerException to be thrown.
     */
    @Test
    public void testGetMaxWithNullArray() {
        Integer[] nullArray = null;
        Assertions.assertThrows(NullPointerException.class, () -> ArrayUtil.getMax(nullArray));
    }

    /**
     * Tests the getMax method with an empty input array and expects an IllegalArgumentException to be thrown.
     */
    @Test
    public void testGetMaxWithEmptyArray() {
        Integer[] emptyArray = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> ArrayUtil.getMax(emptyArray));
    }
}
