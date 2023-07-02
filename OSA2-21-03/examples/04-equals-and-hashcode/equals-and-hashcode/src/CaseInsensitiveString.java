
/**
 * @see Effective Java, 3rd Edition: Item 10: Obey the general contract when overriding equals
 */
public class CaseInsensitiveString {

	String string;

	public CaseInsensitiveString(String string) {
		this.string = string;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof CaseInsensitiveString) {
			return string.equalsIgnoreCase(((CaseInsensitiveString) obj).string);
		}
		if (obj instanceof String) {
			return string.equalsIgnoreCase((String) obj);
		}
		return false;
	}

	@Override
	public String toString() {
		return string;
	}

	public static void main(String[] args) {
		CaseInsensitiveString s1 = new CaseInsensitiveString("test");
		CaseInsensitiveString s2 = new CaseInsensitiveString("Test");
		CaseInsensitiveString s3 = new CaseInsensitiveString("tesT");

		String s = "Test";

		System.out.println("Reflexivity");
		System.out.println(String.format("%s equals %s: %s", s1, s1, s1.equals(s1)));
		System.out.println("Symmetry");
		System.out.println(String.format("%s equals %s: %s", s1, s2, s1.equals(s2)));
		System.out.println(String.format("%s equals %s: %s", s2, s1, s2.equals(s1)));
		System.out.println("Transitivity");
		System.out.println(String.format("%s equals %s: %s", s1, s2, s1.equals(s2)));
		System.out.println(String.format("%s equals %s: %s", s2, s3, s2.equals(s3)));
		System.out.println(String.format("%s equals %s: %s", s1, s3, s1.equals(s3)));
		System.out.println();

		System.out.println("Symmetry");
		System.out.println(String.format("%s equals %s: %s", s1, s, s1.equals(s)));
		System.out.println(String.format("%s equals %s: %s", s, s1, s.equals(s1)));
	}
}
