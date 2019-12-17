/* 3.13 (Employee Class) Create a class called Employee that includes
three instance variables—a first name (type String), a last name (type
String) and a monthly salary (double). Provide a constructor that
initializes the three instance variables. Provide a set and a get method for
each instance variable. If the monthly salary is not positive, do not set its
value. Write a test app named EmployeeTest that demonstrates class
Employee’s capabilities. Create two Employee objects and display
each object’s yearly salary. Then give each Employee a 10% raise and
display each Employee’s yearly salary again. */

package ch03.ex03_13;

public class Employee {
	private String name;
	private String lastName;
	private double salary;

	public Employee(String name, String lastName, double salary) {
		this.name = name;
		this.lastName = lastName;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		if (salary > 0.0)
			this.salary = salary;
	}
}
