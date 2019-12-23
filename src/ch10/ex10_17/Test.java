package ch10.ex10_17;

public class Test {

	public static void main(String[] args) {
		Employee employee1 = new Employee("Sue", "Jones", "222-22-2222", new SalariedCompensationModel(300));
		Employee employee2 = new Employee("Bob", "Lewis", "333-33-3333", new HourlyCompensationModel(15, 45));
		Employee employee3 = new Employee("Karen", "Price", "222-22-2222", new CommissionCompensationModel(10000, .06));
		Employee employee4 = new Employee("Oliver", "Green", "222-22-2222",
				new BasePlusCommissionCompensationModel(10000, .06, 200));

		System.out.printf("%s%n%n", employee1);
		System.out.printf("%s%n%n", employee2);
		System.out.printf("%s%n%n", employee3);
		System.out.printf("%s%n%n", employee4);

		employee2.setCompensationModel(new CommissionCompensationModel(10000, .06));

		System.out.printf("%s%n%n", employee2);
	}

}
