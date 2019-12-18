/* 4.31 (Palindromes) A palindrome is a sequence of characters that reads
the same backward as forward. For example, each of the following fivedigit
integers is a palindrome: 12321, 55555, 45554 and 11611. Write an
application that reads in a five-digit integer and determines whether it’s a
palindrome. If the number is not five digits long, display an error message
and allow the user to enter a new value. */

package ch04.ex04_31;

import java.util.Scanner;

public class Palindromes {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int originalNumber = 0;

		while (originalNumber < 10000) {
			System.out.print("Enter a five-digit integer: ");
			originalNumber = scanner.nextInt();

			if (originalNumber < 10000)
				System.err.println("\nInvalid number. Try again.\n");
		}
		scanner.close();

		int number = originalNumber;

		int reverseNumber = 0;

		while (number > 0) {
			int rem = number % 10;
			number /= 10;
			reverseNumber = reverseNumber * 10 + rem;
		}

		if (originalNumber == reverseNumber)
			System.out.printf("%n%d is palindrome", originalNumber);
		else
			System.out.printf("%n%d is not palindrome", originalNumber);

	}

}
