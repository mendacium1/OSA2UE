package list.impl;

import list.List;

/**
 * Auxilliary interface for the management of the contents of {@link List}.
 *
 * @param <E>
 *            type of the node content
 */
class Node<E> {
	private E element;

	private Node<E> next;

	Node(E element) {
		setElement(element);
	}

	/**
	 * @return element referenced by this node
	 */
	E getElement() {
		return element;
	}

	/**
	 * @param element
	 *            the element to be set
	 */
	void setElement(E element) {
		this.element = element;
	}

	/**
	 * @return get the node following the current node
	 */
	Node<E> getNext() {
		return next;
	}

	/**
	 * @param next
	 *            set the node following the current node
	 */
	void setNext(Node<E> next) {
		this.next = next;
	}
}
