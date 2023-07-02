package override;

public class ClassD extends ClassC {

	static void k() {
		System.out.println("subclass static method");
	}

	@Override
	void m() {
		super.m();
		System.out.println("subclass member method");
	}

}
