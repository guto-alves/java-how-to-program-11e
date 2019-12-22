package ch09.ex09_16;

public class CommissionCompensationModel extends CompensationModel {
	private double grossSales;
	private double commissionRate;

	public CommissionCompensationModel(double grossSales, double commissionRate) {
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}

	@Override
	public double earnings() {
		return grossSales * commissionRate;
	}

}
