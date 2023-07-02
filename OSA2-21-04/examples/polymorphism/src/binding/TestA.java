package binding;
public class TestA {

	public static void main(String[] args) {
		B myB = new A();
		myB.c();

		A myA = (A) myB;
		myA.s();
		myA.m();

		A.z();
	}

}
