package one;

public class Alpha {

	public String publicAlpha;
	protected String protectedAlpha;
	String defaultAlpha;
	private String privateAlpha;

	public static void main(String[] args) {
		Alpha test = new Alpha();

		String s1 = test.publicAlpha;
		String s2 = test.protectedAlpha;
		String s3 = test.defaultAlpha;
		String s4 = test.privateAlpha;

	}

}
