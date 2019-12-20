package ch08.ex08_06;

import java.text.NumberFormat;

public class SavingsAccount {
	private static double annualInterestRate;

	private double savingsBalance;

	public SavingsAccount(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	public void calculateMonthlyInterest() {
		savingsBalance = savingsBalance * (annualInterestRate / 12 / 100 + 1);
	}

	public static void modifyInterestRate(double newAnnualInterestRate) {
		if (newAnnualInterestRate >= 0)
			annualInterestRate = newAnnualInterestRate;
		else
			annualInterestRate = 0;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	@Override
	public String toString() {
		return String.format("%s", NumberFormat.getCurrencyInstance().format(getSavingsBalance()));
	}
}
