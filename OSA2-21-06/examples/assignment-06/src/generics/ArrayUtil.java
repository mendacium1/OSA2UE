package generics;

import java.util.Arrays;

/**
 * Util class provided static helper methods in order to work with arbitrary arrays.
 */
public class ArrayUtil {

	/**
	 * Determines the biggest element within the array according to the natural order of the elements.
	 *
	 * The natural order is determined by the implementation of the interface {@link Comparable}.
	 *
	 * @param values the list of values to determine the biggest element of
	 * @param <T> any type extends {@link Comparable}
	 * @return the biggest element within the array according to the natural order of elements
	 * @throws NullPointerException in case values is {@code null}
	 * @throws IllegalArgumentException in case the list is empty
	 */
	public static <T extends Comparable<T>> T biggest(T[] values) {
		if (values == null) {
			throw new NullPointerException();
		}
		if (values.length == 0) {
			throw new IllegalArgumentException("No values provided to determine biggest element.");
		}
		if (values.length == 1) {
			return values[0];
		}
		T[] sortedValues = Arrays.copyOf(values, values.length);
		Arrays.sort(sortedValues);
		return sortedValues[sortedValues.length - 1];
	}

}
