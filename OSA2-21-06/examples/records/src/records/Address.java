package records;

public record Address(String street, String city) {
	public Address {
		if (city == null) {
			throw new IllegalArgumentException();
		}
	}
}
