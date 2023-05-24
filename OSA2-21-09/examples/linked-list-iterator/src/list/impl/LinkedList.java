package list.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

import list.List;

/**
 * Linked list containing object elements.
 */
public class LinkedList<E> implements List<E>, Iterable<E> {

	private Node<E> head;
	private int size = 0;

	/**
	 * Adds the element at the beginning of the current list.
	 *
	 * @see {@link List#add(Object)}
	 */
	@Override
	public void add(E element) {
		Node<E> node = new Node<E>(element);
		if (head != null) {
			node.setNext(head);
		}
		this.head = node;
		size++;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E search(E element) {
		if (head == null) {
			return null;
		}
		Node<E> current = head;
		do {
			if (Objects.equals(current.getElement(), element)) {
				return current.getElement();
			}
			current = current.getNext();
		} while (current != null);
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E remove(E element) {
		if (head == null) {
			return null;
		}
		Node<E> current = head;
		Node<E> previous = null;
		do {
			if (Objects.equals(current.getElement(), element)) {
				if (previous != null) {
					previous.setNext(current.getNext());
				} else {
					this.head = current.getNext();
				}
				size--;
				return current.getElement();
			}
			previous = current;
			current = current.getNext();
		} while (current != null);
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		return this.new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<E> {
		private Node<E> cursor = head;

		@Override
		public boolean hasNext() {
			return (cursor != null);
		}

		@Override
		public E next() {
			if (cursor == null) {
				throw new NoSuchElementException();
			}
			E result = cursor.getElement();
			cursor = cursor.getNext();
			return result;
		}
	}

}
