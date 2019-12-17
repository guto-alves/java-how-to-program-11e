/*
 *2.16 (Comparing Integers) Write an application that asks the user to enter
 * two integers, obtains them from the user and displays the larger number
 * followed by the words "is larger". If the numbers are equal, print the
 * message "These numbers are equal". Use the techniques shown in Fig. 2.15.
 *
 * Autor: Gustavo Alves
 */

package ch02.ex02_16;

import java.util.Scanner;

public class Comparison {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter first number: ");
		int number1 = scanner.nextInt();

		System.out.print("Enter second number: ");
		int number2 = scanner.nextInt();
		scanner.close();

		if (number1 == number2)
			System.out.println("These numbers are equal");

		if (number1 > number2)
			System.out.printf("%d is larger", number1);

		if (number1 < number2)
			System.out.printf("%d is larger", number2);
	}
}