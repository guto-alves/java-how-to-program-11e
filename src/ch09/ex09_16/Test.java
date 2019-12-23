package ch09.ex09_16;

public class Test {

	public static void main(String[] args) {
		Employee employee1 = new Employee("Bob", "Lewis", "333-33-3333", new CommissionCompensationModel(5000, .04));
		Employee employee2 = new Employee("Sue", "Jones", "222-22-2222",
				new BasePlusCommissionCompensationModel(10000, .06, 200));

		System.out.printf("%s%n%n", employee1);
		System.out.printf("%s%n%n", employee2);

		employee2.setCompensationModel(new CommissionCompensationModel(10000, .06));

		System.out.printf("%s%n%n", employee2);
	}

}
