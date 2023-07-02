public class BoxingDay {

	public static void main(String[] args) {
		withoutAutoboxing();
		withAutoboxing();

		compare();
	}

	static void withoutAutoboxing() {
		Character cObject = Character.valueOf('a');
		char cPrimitive = cObject.charValue();

		System.out.print(cObject);
		System.out.println(cPrimitive);
	}

	static void withAutoboxing() {
		Character cObject = 'a';
		char cPrimitive = cObject;

		System.out.print(cObject);
		System.out.println(cPrimitive);
	}

	static void compare() {
		// autoboxing
		System.out.println('a' == Character.valueOf('a'));

		// no autoboxing!
		System.out.println(new Character('a') == new Character('a'));
		System.out.println(new Character('a').equals(new Character('a')));

		System.out.println(Character.valueOf('a') == Character.valueOf('a'));
	}
}
