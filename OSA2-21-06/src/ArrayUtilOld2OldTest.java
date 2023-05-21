import org.testng.annotations.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ArrayUtilOld2OldTest {

    private final Optional<ArrayList<Comparable>> inputList;
    private final Comparable expectedResult;

    public ArrayUtilOld2OldTest(Optional<ArrayList<Comparable>> inputList, Comparable expectedResult) {
        this.inputList = inputList;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static List<Object[]> testCases() {
        return Arrays.asList(
                new Object[][]{
                        {Optional.of(new ArrayList<>(Arrays.asList(1, 2, 3))), 3},
                        {Optional.of(new ArrayList<>(Arrays.asList(2, 2, 2))), 2},
                        {Optional.of(new ArrayList<>(Arrays.asList(-1, -2, -3))), -1},
                        {Optional.of(new ArrayList<>(Collections.singleton(5))), 5},
                        {Optional.of(new ArrayList<>(Arrays.asList("foo", "bar", "baz"))), "foo"}
                });
    }

    @Test
    public void testGetMax() {
        assertEquals(expectedResult, ArrayUtil_old.getMax(inputList));
    }

    @Test
    public void testGetMaxWithNoList() {
        assertThrows(NullPointerException.class, () -> ArrayUtil_old.getMax(null));
    }

    @Test
    public void testGetMaxWithEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> ArrayUtil_old.getMax(Optional.of(new ArrayList<>())));
    }
}
