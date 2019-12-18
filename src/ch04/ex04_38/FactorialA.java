/* 1. Write an application that reads a nonnegative integer and
computes and prints its factorial. */

package ch04.ex04_38;

import java.util.Scanner;

public class FactorialA {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a positive integer: ");
		int number = scanner.nextInt();
		scanner.close();

		int aux = number;

		int factorial = 1;
		while (number > 1) {
			factorial *= number;
			number--;
		}

		System.out.printf("%d! = %d", aux, factorial);
	}
}
