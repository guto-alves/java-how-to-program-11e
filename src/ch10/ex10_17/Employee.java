package ch10.ex10_17;

public class Employee {
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private CompensationModel compensationModel;

	public Employee(String firstName, String lastName, String socialSecurityNumber,
			CompensationModel compensationModel) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.compensationModel = compensationModel;
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

	public void setCompensationModel(CompensationModel compensationModel) {
		this.compensationModel = compensationModel;
	}

	public double earnings() {
		return compensationModel.earnings();
	}

	@Override
	public String toString() {
		return String.format("%s: %s %s%n%s: %s%n%s %.2f", "employee", firstName, lastName, "social security number",
				socialSecurityNumber, "earnings", earnings());
	}
}
