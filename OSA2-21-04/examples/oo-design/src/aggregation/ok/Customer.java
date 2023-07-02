package aggregation.ok;

public class Customer {

	String name;
	Address address;

	public Customer(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + "]";
	}

}
