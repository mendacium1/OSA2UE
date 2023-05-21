/**
 * Utility class for array manipulation.
 *
 * @author Jakob Mayr
 */
public class ArrayUtil {

    /**
     * Returns the maximum value in the input array.
     *
     * @param arr the input array to find the maximum value from
     * @return the maximum value in the input array
     * @throws NullPointerException if the input array is null
     * @throws IllegalArgumentException if the input array is empty
     */
    public static <E extends Comparable<? super E>> E getMax(E[] arr) {
        if (arr == null) {
            throw new NullPointerException("Array can not be null");
        }
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array can not be empty");
        }

        E max = arr[0];

        for (E e : arr) {
            if (e.compareTo(max) > 0) {
                max = e;
            }
        }

        return max;
    }

}
