/* 6.16 (Multiples) Write a method isMultiple that determines, for a pair
of integers, whether the second integer is a multiple of the first. The
method should take two integer arguments and return true if the second
is a multiple of the first and false otherwise. [Hint: Use the remainder
operator.] Incorporate this method into an application that inputs a series
of pairs of integers (one pair at a time) and determines whether the second
value in each pair is a multiple of the first. */

package ch06.ex06_16;

import java.util.Scanner;

public class Multiples {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter an integer: ");
		int number1 = scanner.nextInt();

		System.out.print("Enter another integer: ");
		int number2 = scanner.nextInt();
		scanner.close();

		System.out.printf("%n%d is a multiple of %d? %s", number2, number1, isMultiple(number1, number2));
	}

	public static boolean isMultiple(int number1, int number2) {
		return number2 % number1 == 0 ? true : false;
	}

}
