// Fig. 3.9: AccountTest.java
// Inputting and outputting floating-point numbers with Account objects.

package ch03.ex03_15;

import java.util.Scanner;

public class AccountTest {
	public static void main(String[] args) {
		Account account1 = new Account("Jane Green", 50.00);
		Account account2 = new Account("John Blue", -7.53);

		// display initial balance of each object
		displayAccount(account1);
		displayAccount(account2);
		System.out.println();

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.print("Enter deposit amount for account1: "); // prompt
		double depositAmount = input.nextDouble(); // obtain user input
		System.out.printf("%nadding %.2f to account1 balance%n%n", depositAmount);
		account1.deposit(depositAmount); // add to account1's balance

		// display balances
		displayAccount(account1);
		displayAccount(account2);
		System.out.println();

		System.out.print("Enter deposit amount for account2: "); // prompt
		depositAmount = input.nextDouble(); // obtain user input
		System.out.printf("%nadding %.2f to account2 balance%n%n", depositAmount);
		account2.deposit(depositAmount); // add to account2 balance

		// display balances
		displayAccount(account1);
		displayAccount(account2);
	}

	public static void displayAccount(Account account) {
		System.out.printf("%s balance: $%.2f%n", account.getName(), account.getBalance());
	}
}