package enhanced;

public class DeepCopy extends AbstractCopy implements Cloneable {
	Content additionalInformation;

	public DeepCopy(String information, String additionalInformation) {
		super(new Content(information));
		this.additionalInformation = new Content(additionalInformation);
	}

	@Override
	public String toString() {
		return super.toString() + " " + additionalInformation.toString();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		DeepCopy clone = (DeepCopy) super.clone();
		clone.information = (Content) this.information.clone();
		clone.additionalInformation = (Content) this.additionalInformation.clone();
		return clone;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		DeepCopy original = new DeepCopy("one", "two");
		DeepCopy copy = (DeepCopy) original.clone();

		System.out.println("Original: " + original);
		System.out.println("Copy:     " + copy);

		copy.information.value = "foo";

		System.out.println("Original: " + original);
		System.out.println("Copy:     " + copy);
	}
}
