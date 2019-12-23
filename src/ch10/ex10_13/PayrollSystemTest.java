// Fig. 10.9: PayrollSystemTest.java
// Employee hierarchy test program.

package ch10.ex10_13;

public class PayrollSystemTest {
	public static void main(String[] args) {
		// create subclass objects
		SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", new Date(1, 27, 2000),
				800.00);
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", new Date(2, 27, 2000),
				16.75, 40);
		CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333",
				new Date(3, 27, 2000), 10000, .06);
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis",
				"444-44-4444", new Date(4, 27, 2000), 5000, .04, 300);

		// create four-element Employee array
		Employee[] employees = new Employee[4];

		// initialize array with Employees
		employees[0] = salariedEmployee;
		employees[1] = hourlyEmployee;
		employees[2] = commissionEmployee;
		employees[3] = basePlusCommissionEmployee;

		int currentMonth = 1;
		System.out.printf("Payroll -> Month %d:%n%n", currentMonth);

		// generically process each element in array employees
		for (Employee currentEmployee : employees) {
			System.out.println(currentEmployee); // invokes toString

			// determine whether element is a BasePlusCommissionEmployee
			if (currentEmployee instanceof BasePlusCommissionEmployee) {
				// downcast Employee reference to
				// BasePlusCommissionEmployee reference
				BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;

				employee.setBaseSalary(1.10 * employee.getBaseSalary());

				System.out.printf("new base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
			}

			if (currentEmployee.getBirthDate().getMonth() == currentMonth)
				System.out.printf("earned $%,.2f - with a $100.00 bonus. Happy birthday%n%n",
						currentEmployee.earnings() + 100);
			else
				System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings());
		}

		// get type name of each object in employees array
		for (int j = 0; j < employees.length; j++) {
			System.out.printf("Employee %d is a %s%n", j, employees[j].getClass().getSimpleName());
		}
	}
}
