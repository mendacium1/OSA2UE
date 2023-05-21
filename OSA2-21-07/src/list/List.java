package list;

/**
 * A dynamically growing list.
 * <p>
 * The elements are not necessarily unique throughout the list.
 *
 *  @param <E> the type of elements in this list
 *
 * @author Claudia
 * @version 1.0
 */
interface List<E> {

    /**
     * Adds an element to the list.
     *
     * The element is inserted at the end of the list.
     *
     * @param element
     *            the element which should be added to the list.
     */
    void add(E element);

    /**
     * Removes elements which are equal to the parameter from the list.
     * <p>
     * If there are more entries with the same element, all elements equal to the parameter are removed.
     *
     * @param element
     *            all entries equal to this string are to be removed
     */
    void remove(E element);

    /**
     * @return the current number of elements in the list.
     */
    int size();

    /**
     * @return <code>true</code> if there are no elements in the list,
     *         <code>false</code> otherwise
     */
    boolean isEmpty();

    /**
     * Returns the entry at the given index from the list.
     *
     * If the index has no suitable value, the method returns <code>null</code>.
     *
     * @param index
     *            the position of the entry in the list
     * @return the entry at the given position
     */
    E get(int index);

    /**
     * @return the first entry in the list.
     */
    E getHead();

    /**
     * @return the last entry in the list.
     */
    E getTail();

    /**
     * Removes all entries from the list.
     */
    void clear();

    /**
     * @return a <code>String</code> representation of the list.
     */
    @Override
    String toString();

}
