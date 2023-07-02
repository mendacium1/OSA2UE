package aggregation.ok;

public class Address {

	String street;
	String postcode;
	String city;

	public Address(String street, String postcode, String city) {
		this.street = street;
		this.postcode = postcode;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", postcode=" + postcode + ", city=" + city + "]";
	}

}
