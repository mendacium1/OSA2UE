package binding;
public class A implements B {
	int property;

	public A() {
		this(0);
	}

	public A(int property) {
		this.property = property;
	}

	@Override
	public void c() {

	}

	public void s() {

	}

	public void m() {
		c();
		s();
	}

	public static void z() {

	}

}
