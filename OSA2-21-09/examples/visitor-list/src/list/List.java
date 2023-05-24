package list;

/**
 * A dynamic linear list of objects.
 * 
 */
public interface List<E> {

	/**
	 * Adds the given element to the list.
	 * 
	 * @param element
	 *            new element to add to list
	 */
	void add(E element);

	/**
	 * Searches for an element with the given identifier.
	 * <p>
	 * If the list contains more than one matching element, the first matching element will be returned.
	 * <p>
	 * If there is no matching element, then <code>null</null> will be returned.
	 * 
	 * @param element
	 *            the element to search for
	 * @return the first element matching the given identifier
	 */
	E search(E element);

	/**
	 * Removes an element with the given identifier.
	 * <p>
	 * If the list contains more than one element with the given identifier, the first matching element will be removed.
	 * <p>
	 * If there is no matching element, then the list remains unchanged and <code>null</code> will be returned.
	 * 
	 * @param element
	 *            the element to remove
	 * @return the element which has been removed
	 */
	E remove(E element);

	/**
	 * @return the number of elements currently contained in the list
	 */
	int size();

}
