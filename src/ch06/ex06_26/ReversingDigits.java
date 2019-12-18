/* 6.26 (Reversing Digits) Write a method that takes an integer value and
returns the number with its digits reversed. For example, given the number
7631, the method should return 1367. Incorporate the method into an
application that reads a value from the user and displays the result. */

package ch06.ex06_26;

import java.util.Scanner;

public class ReversingDigits {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter an integer: ");
		int value = input.nextInt();
		input.close();

		System.out.println(reverse(value));
	}

	public static int reverse(int value) {
		int reverted = 0;

		while (value != 0) {
			int rem = value % 10;
			value /= 10;
			reverted = rem + 10 * reverted;
		}

		return reverted;
	}
}
