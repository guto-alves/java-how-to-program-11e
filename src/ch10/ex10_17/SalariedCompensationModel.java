package ch10.ex10_17;

public class SalariedCompensationModel implements CompensationModel {
	private double weeklySalary;

	public SalariedCompensationModel(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}

	@Override
	public double earnings() {
		return weeklySalary;
	}
}
