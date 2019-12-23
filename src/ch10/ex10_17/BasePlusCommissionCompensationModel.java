package ch10.ex10_17;

public class BasePlusCommissionCompensationModel implements CompensationModel {
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
