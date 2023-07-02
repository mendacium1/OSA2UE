package staticmembers;

public class ClassA {

	static int instanceCounter = 0;

	static int getNumberOfInstances() {
		return instanceCounter;
	}

	public ClassA() {
		instanceCounter++;
	}

}
