package list.impl;

import java.util.Iterator;

public class IteratorTest {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();

		list.add("one");
		list.add("two");
		list.add("three");

		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println("while: " + iterator.next());
		}

		System.out.println();

		for (String string : list) {
			System.out.println("foreach: " + string);
		}

	}

}
