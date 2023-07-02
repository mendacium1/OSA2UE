package override;

public class TestOverride {

	public static void main(String[] args) {
		ClassC.k();
		ClassD.k();
		System.out.println();

		ClassC c1 = new ClassC();
		ClassC c2 = new ClassD();
		ClassD d1 = new ClassD();

		c1.k();
		c1.m();
		System.out.println();

		c2.k();
		c2.m();
		System.out.println();

		d1.k();
		d1.m();
	}

}
