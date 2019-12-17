/*
 * 2.26 (Multiples) Write an application that reads two integers, determines
 * whether the first is a multiple of the second and prints the result. [Hint:
 * Use the remainder operator.]
 */

package ch02.ex02_26;

import java.util.Scanner;

public class Multiples {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter first integer: ");
		int number1 = input.nextInt();

		System.out.print("Enter second integer: ");
		int number2 = input.nextInt();
		input.close();

		if (number1 % number2 == 0)
			System.out.printf("%d is a multiple of %d%n", number1, number2);

		if (number1 % number2 != 0)
			System.out.printf("%d is not a multiple of %d%n", number1, number2);
	}
}
