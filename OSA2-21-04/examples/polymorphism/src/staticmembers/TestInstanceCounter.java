package staticmembers;

public class TestInstanceCounter {

	public static void main(String[] args) {

		System.out.println("Class A: " + ClassA.getNumberOfInstances());
		System.out.println("Class B: " + ClassB.getNumberOfInstances());
		System.out.println();

		ClassA a1 = new ClassA();

		System.out.println("Class A: " + ClassA.getNumberOfInstances());
		System.out.println("Class B: " + ClassB.getNumberOfInstances());
		System.out.println();

		ClassB b1 = new ClassB();

		System.out.println("Class A: " + ClassA.getNumberOfInstances());
		System.out.println("Class B: " + ClassB.getNumberOfInstances());
		System.out.println();

		System.out.println("a1: " + a1.getNumberOfInstances());
		System.out.println("b1: " + b1.getNumberOfInstances());
		System.out.println();

		ClassA a2 = b1;

		System.out.println("b1: " + b1.getNumberOfInstances());
		System.out.println("a2: " + a2.getNumberOfInstances());
	}

}
