package trace;

import trace.a.ClassA;

public class StacktraceExample {

	public static void main(String[] args) {
		ClassA a = new ClassA();
		a.methodA();
	}

}
