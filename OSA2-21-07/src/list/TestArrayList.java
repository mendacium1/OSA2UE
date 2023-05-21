/**
 * This class contains JUnit test cases for the ArrayList implementation.
 * @author Jakob Mayr
 */

package list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class TestArrayList {

    private ArrayList<String> listString;
    private ArrayList<Object> listMixed = new ArrayList<>();

    /**
     * Initializes the ArrayList before each test.
     */
    @BeforeEach
    void setUp() {
        listString = new ArrayList<>();
    }

    /**
     * Tests the add() method of the ArrayList.
     */
    @Test
    void testAdd() {
        listString.add("a");
        listString.add("b");
        listString.add("c");
        assertEquals(3, listString.size());
    }

    /**
     * Tests the remove() method of the ArrayList.
     */
    @Test
    void testRemove() {
        listString.add("a");
        listString.add("b");
        listString.add("c");
        listString.remove("b");
        assertEquals(2, listString.size());
        assertEquals("c", listString.get(1));
    }

    /**
     * Tests the size() method of the ArrayList.
     */
    @Test
    void testSize() {
        assertEquals(0, listString.size());
        listString.add("a");
        listString.add("b");
        assertEquals(2, listString.size());
    }

    /**
     * Tests the isEmpty() method of the ArrayList.
     */
    @Test
    void testIsEmpty() {
        assertTrue(listString.isEmpty());
        listString.add("a");
        assertFalse(listString.isEmpty());
    }

    /**
     * Tests the get() method of the ArrayList.
     */
    @Test
    void testGet() {
        listString.add("a");
        listString.add("b");
        listString.add("c");
        assertEquals("b", listString.get(1));
        assertNull(listString.get(3));
    }

    /**
     * Tests the getHead() method of the ArrayList.
     */
    @Test
    void testGetHead() {
        listString.add("a");
        listString.add("b");
        listString.add("c");
        assertEquals("a", listString.getHead());
        listString.remove("a");
        assertEquals("b", listString.getHead());
    }

    /**
     * Tests the getTail() method of the ArrayList.
     */
    @Test
    void testGetTail() {
        listString.add("a");
        listString.add("b");
        listString.add("c");
        assertEquals("c", listString.getTail());
        listString.remove("c");
        assertEquals("b", listString.getTail());
    }

    /**
     * Tests the clear() method of the ArrayList.
     */
    @Test
    void testClear() {
        listString.add("a");
        listString.add("b");
        listString.clear();
        assertEquals(0, listString.size());
    }

    /**
     * Tests the toString() method of the ArrayList.
     */
    @Test
    void testToString() {
        listString.add("a");
        listString.add("b");
        listString.add("c");
        assertEquals("abc", listString.toString());
    }

    /**
     * Tests the adjust() method of the ArrayList.
     */
    @Test
    void testAdjust() {
        listString.add("a");
        listString.add("b");
        listString.add("c");
        listString.add("d");
        listString.add("e");
        listString.add("f");
        listString.add("g");
        listString.add("h");
        listString.add("i");
        assertEquals(9, listString.size());
        assertEquals("b", listString.get(1));
    }

    /**
     * Tests all null-returning functions.
     */
    @Test
    void testNullReturns() {
        assertNull(listString.getTail());
        assertNull(listString.getHead());
        assertNull(listString.get(2));
        listString.add("a");
        listString.add("b");
        listString.add("c");
        listString.add("d");
        listString.add("e");
        assertNull(listString.get(6));
        listString.clear();
        assertNull(listString.getTail());
        assertNull(listString.getTail());
        assertNull(listString.get(0));
    }

    /**
     * Extensive tests with different types mixed together.
     */
    @Test
    void testWithDifferentElements() {
        listMixed.add(1);
        listMixed.add("b");
        listMixed.add(Collections.singleton(5));
        listMixed.add(80.89);
        listMixed.add(Arrays.asList(7, 8, 9));
        assertThrows(IllegalArgumentException.class, () -> listMixed.add(null));
        listMixed.add("End");

        assertEquals(1, listMixed.get(0));
        assertEquals("b", listMixed.get(1));
        assertEquals(Collections.singleton(5), listMixed.get(2));
        assertEquals(80.89, listMixed.get(3));
        assertEquals(Arrays.asList(7, 8, 9), listMixed.get(4));
        assertEquals("End", listMixed.get(5));
        assertNull(listMixed.get(6));
        assertFalse(listMixed.isEmpty());

        listMixed.remove(3);

        assertEquals("End", listMixed.get(5));
        assertNull(listMixed.get(6));
        assertEquals(6, listMixed.size());
        assertEquals("1b[5]80.89[7, 8, 9]End", listMixed.toString());

        listMixed.clear();
        assertEquals(0, listMixed.size());
        assertTrue(listMixed.isEmpty());
    }

}
