package values;

public class Main {

	public static void main(String[] args) {
		Address address1 = new Address("Musterstraße", "Musterstadt");
		System.out.println(address1);
		System.out.println(address1.getStreet());

		Address address2 = new Address("Mustergasse", "Musterort");
		Address address3 = new Address("Musterstraße", "Musterstadt");

		System.out.println(address1.equals(address2));
		System.out.println(address1.equals(address3));

		new Address("Musterallee", null);
	}

}
