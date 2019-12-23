package ch10.ex10_17;

public class CommissionCompensationModel implements CompensationModel {
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
