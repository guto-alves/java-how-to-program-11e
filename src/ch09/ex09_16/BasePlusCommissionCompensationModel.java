package ch09.ex09_16;

public class BasePlusCommissionCompensationModel extends CompensationModel {
	private double grossSales;
	private double commissionRate;
	private double baseSalary;

	public BasePlusCommissionCompensationModel(double grossSales, double commissionRate, double baseSalary) {
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
		this.baseSalary = baseSalary;
	}

	@Override
	public double earnings() {
		return baseSalary + grossSales * commissionRate;
	}
}
