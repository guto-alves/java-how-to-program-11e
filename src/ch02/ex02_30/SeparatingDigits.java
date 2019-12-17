/* 2.30 (Separating the Digits in an Integer) Write an application that inputs
one number consisting of five digits from the user, separates the number
into its individual digits and prints the digits separated from one another
by three spaces each. For example, if the user types in the number 42339,
the program should print
4 2 3 3 9
Assume that the user enters the correct number of digits. What happens
when you enter a number with more than five digits? What happens when
you enter a number with fewer than five digits? [Hint: It’s possible to do
this exercise with the techniques you learned in this chapter. You’ll need to
use both division and remainder operations to “pick off ” each digit.] */

package ch02.ex02_30;

import java.util.Scanner;

public class SeparatingDigits {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.printf("Enter a five-digit integer: ");
		int number = scanner.nextInt();
		scanner.close();

		int digit1 = number % 10;
		number /= 10;
		int digit2 = number % 10;
		number /= 10;
		int digit3 = number % 10;
		number /= 10;
		int digit4 = number % 10;
		number /= 10;
		int digit5 = number % 10;
		number /= 10;

		System.out.printf("%d   %d   %d   %d   %d%n", digit5, digit4, digit3, digit2, digit1);
	}

}
