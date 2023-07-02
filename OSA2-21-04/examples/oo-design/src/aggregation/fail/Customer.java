package aggregation.fail;

public class Customer {

	String name;

	String street;
	String postcode;
	String city;

	public Customer(String name, String street, String postcode, String city) {
		this.name = name;
		this.street = street;
		this.postcode = postcode;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", street=" + street + ", postcode=" + postcode + ", city=" + city + "]";
	}

}
