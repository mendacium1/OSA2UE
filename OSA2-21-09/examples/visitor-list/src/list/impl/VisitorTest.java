package list.impl;

import list.Visitor;

public class VisitorTest {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();

		list.add("one");
		list.add("two");
		list.add("three");

		for (Node<String> node : list) {
			node.accept(new PrintVisitor());
			node.accept(new UpperCaseVisitor());
		}

	}

	public static class PrintVisitor implements Visitor<String> {
		@Override
		public void visit(String element) {
			System.out.println(element);
		}
	}

	public static class UpperCaseVisitor implements Visitor<String> {
		@Override
		public void visit(String element) {
			System.out.println(element.toUpperCase());
		}
	}
}
