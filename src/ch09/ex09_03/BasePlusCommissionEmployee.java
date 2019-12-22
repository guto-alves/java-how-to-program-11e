// Fig. 9.11: BasePlusCommissionEmployee.java
// BasePlusCommissionEmployee class inherits from CommissionEmployee 
// and accesses the superclass’s private data via inherited 
// public methods.

package ch09.ex09_03;

public class BasePlusCommissionEmployee {
	private CommissionEmployee commissionEmployee;
	private double baseSalary; // base salary per week

	// six-argument constructor
	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary) {
		commissionEmployee = new CommissionEmployee(firstName, lastName, socialSecurityNumber, grossSales,
				commissionRate);

		// if baseSalary is invalid throw exception
		if (baseSalary < 0.0) {
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}

		this.baseSalary = baseSalary;
	}

	public CommissionEmployee getCommissionEmployee() {
		return commissionEmployee;
	}

	// set base salary
	public void setBaseSalary(double baseSalary) {
		if (baseSalary < 0.0) {
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}

		this.baseSalary = baseSalary;
	}

	// return base salary
	public double getBaseSalary() {
		return baseSalary;
	}

	public double earnings() {
		return getBaseSalary() + commissionEmployee.earnings();
	}

	// return String representation of BasePlusCommissionEmployee
	@Override
	public String toString() {
		return String.format("%s %s%n%s: %.2f", "base-salaried", commissionEmployee, "base salary", getBaseSalary());
	}
}

/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 *************************************************************************/
