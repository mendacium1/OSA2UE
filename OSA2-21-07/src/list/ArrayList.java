/**
 * The ArrayList class provides an implementation of the List interface,
 * using an array as the underlying data structure to store the list elements.
 *
 * @param <E> the type of elements stored in the list
 * @author Jakob Mayr
 */
package list;
import java.util.Arrays;

public class ArrayList<E> implements List<E> {

    /**
     * The initial size of the array used to store the list elements.
     */
    private final int initialSize = 4;

    /**
     * The array used to store the list elements.
     */
    private E[] elements = (E[]) new Object[initialSize];

    /**
     * The index of the last element in the list.
     */
    private int lastElementPointer = 0;

    /**
     * Increases the size of the elements array if necessary to accommodate the
     * addition of a new element.
     *
     * @param newSize the desired new size of the elements array
     */
    private void adjustSize(int newSize) {
        if (newSize - elements.length > 0) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    /**
     * Adds a new element to the end of the list.
     *
     * @param element the element to add to the list
     */
    @Override
    public void add(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element can not be null");
        }
        adjustSize(elements.length + 1);
        elements[lastElementPointer] = element;
        lastElementPointer += 1;
    }

    /**
     * Removes all occurrence of a specified element from the list.
     *
     * @param element the element to remove from the list
     */
    @Override
    public void remove(E element) {
        E[] tmpArray = (E[]) new Object[elements.length];
        int countOfDeletedElements = 0;
        for (int i = 0; i < lastElementPointer; i++) {
            if (elements[i].equals(element)) {
                countOfDeletedElements++;
            }
            else {
                tmpArray[i-countOfDeletedElements] = elements[i];
            }
        }
        lastElementPointer -= countOfDeletedElements;
        elements = Arrays.copyOf(tmpArray, elements.length);
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        return lastElementPointer;
    }

    /**
     * Returns true if the list is empty, false otherwise.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return lastElementPointer <= 0;
    }

    /**
     * Returns the element at the specified index in the list.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index, or null if the index is out of range
     */
    @Override
    public E get(int index) {
        return (index >= lastElementPointer || index < 0) ? null : elements[index];
    }

    /**
     * Returns the first element in the list.
     *
     * @return the first element in the list, or null if the list is empty
     */
    @Override
    public E getHead() {
        return (lastElementPointer > 0) ? elements[0] : null;
    }

    /**
     * Returns the last element in the list.
     *
     * @return the last element in the list, or null if the list is empty
     */
    @Override
    public E getTail() {
        return (lastElementPointer > 0) ? elements[lastElementPointer - 1] : null;
    }

    /**
     * Clears the list.
     */
    @Override
    public void clear() {
        lastElementPointer = 0;
    }

    /**
     * Creates a string by calling all elements toString functions and concatenating them.
     *
     * @return the concatenation of all elements toString-functions.
     */
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        for (int i = 0; i < lastElementPointer; i++) {
            outputString.append(elements[i].toString());
        }
        return outputString.toString();
    }
}
