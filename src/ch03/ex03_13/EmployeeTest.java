package ch03.ex03_13;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee employee1 = new Employee("Jane", "Green", 2000);
		Employee employee2 = new Employee("John", "Blue", 1000);

		System.out.printf("%s %s salary: $%.2f%n", employee1.getName(), employee1.getLastName(), employee1.getSalary());
		System.out.printf("%s %s salary: $%.2f%n%n", employee2.getName(), employee2.getLastName(),
				employee2.getSalary());

		employee1.setSalary(employee1.getSalary() * 1.10);
		employee2.setSalary(employee2.getSalary() * 1.10);

		System.out.println("Yearly salaries with a 10% raise\n");

		System.out.printf("%s %s salary: $%.2f%n", employee1.getName(), employee1.getLastName(), employee1.getSalary());
		System.out.printf("%s %s salary: $%.2f%n", employee2.getName(), employee2.getLastName(), employee2.getSalary());
	}
}
