/* 6.21 (Separating Digits)Write methods that accomplish each of the
following tasks:

1. Calculate the integer part of the quotient when integer a is
divided by integer b.

2. Calculate the integer remainder when integer a is divided by
integer b.

3. Use the methods developed in parts (a) and (b) to write a method
displayDigits that receives an integer between 1 and
99999 and displays it as a sequence of digits, separating each
pair of digits by two spaces. For example, the integer 4562
should appear as
		4  5  6  2

Incorporate the methods into an application that inputs an integer
and calls displayDigits by passing the method the integer
entered. Display the results. */

package ch06.ex06_21;

import java.util.Scanner;

public class SeparatingDigits {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int number;
		do {
			System.out.print("Enter a number between 1 and 99999: ");
			number = input.nextInt();
		} while (number < 1 || number > 99999);
		input.close();

		displayDigits(number);
	}

	public static int quotient(int a, int b) {
		return a / b;
	}

	public static int rem(int a, int b) {
		return a % b;
	}

	public static void displayDigits(int number) {
		String result = "";

		while (number != 0) {
			int rem = rem(number, 10);
			number = quotient(number, 10);
			result = rem + "  " + result;
		}

		System.out.println(result);
	}
}
