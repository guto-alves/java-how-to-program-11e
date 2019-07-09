package ch09.ex09_15;

public class Employee {
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;

	public Employee(String firstName, String lastName, String socialSecurityNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	@Override
	public String toString() {
		return String.format("First name: %s%nLast name: %s%nSocial security number: %s%n", getFirstName(),
				getLastName(), getSocialSecurityNumber());
	}
}
