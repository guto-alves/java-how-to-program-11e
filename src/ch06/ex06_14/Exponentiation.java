/* 6.14 (Exponentiation) Write a method integerPower(base,
exponent) that returns the value of
base
For example, integerPower(3, 4) calculates 3 (or 3 * 3 * 3 * 3).
Assume that exponent is a positive, nonzero integer and that base is an
integer. Use a for or while statement to control the calculation. Do not
use any Math class methods. Incorporate this method into an application
that reads integer values for base and exponent and performs the
calculation with the integerPower method. */

package ch06.ex06_14;

import java.util.Scanner;

public class Exponentiation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter an integer value for the base: ");
		int base = scanner.nextInt();

		System.out.print("Enter the exponent: ");
		int exponent = scanner.nextInt();
		scanner.close();

		System.out.printf("%n%d ^ %d = %d", base, exponent, integerPower(base, exponent));
	}

	public static int integerPower(int base, int exponent) {
		int result = 1;

		for (int i = 0; i < exponent; i++)
			result *= base;

		return result;
	}
}
