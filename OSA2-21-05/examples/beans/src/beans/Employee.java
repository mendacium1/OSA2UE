package beans;

public class Employee {

	String name;
	boolean retired;

	public Employee(String name) {
		this.name = name;
	}

	String getFullName() {
		return name;
	}

	void setFullName(String name) {
		this.name = name;
	}

	boolean getRetired() {
		return retired;
	}

	void setRetiredState(boolean retired) {
		this.retired = retired;
	}

}
