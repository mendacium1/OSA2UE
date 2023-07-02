package trace.a;

import trace.b.ClassB;

public class ClassA {

	public void methodA() {
		ClassB b = new ClassB();
		b.methodB();
	}

}
