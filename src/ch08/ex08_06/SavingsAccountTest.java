package ch08.ex08_06;

public class SavingsAccountTest {

	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount(1000);
		SavingsAccount saver2 = new SavingsAccount(3000);

		SavingsAccount.modifyInterestRate(4);

		for (int i = 0; i < 12; i++) {
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
		}

		System.out.printf("saver1 %s%n", saver1);
		System.out.printf("saver2 %s%n", saver2);

		SavingsAccount.modifyInterestRate(5);

		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();

		System.out.printf("saver1 %s%n", saver1);
		System.out.printf("saver2 %s%n", saver2);
	}

}
