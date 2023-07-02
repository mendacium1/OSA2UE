package staticmembers;

public class ClassB extends ClassA {

	static int instanceCounter = 0;

	static int getNumberOfInstances() {
		return instanceCounter;
	}

	public ClassB() {
		instanceCounter++;
	}

}
