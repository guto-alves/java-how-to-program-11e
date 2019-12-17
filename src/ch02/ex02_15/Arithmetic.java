/*
 * 2.15 (Arithmetic) Write an application that asks the user to enter two
 * integers, obtains them from the user and prints their sum, product,
 * difference and quotient (division). Use the techniques shown in Fig. 2.7.
 * 
 * Author: Gustavo Alves
 */

package ch02.ex02_15;

import java.util.Scanner;

public class Arithmetic {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int number1;
		int number2;
		int sum, sub, div, mul;

		System.out.print("Enter first integer: ");
		number1 = input.nextInt();

		System.out.print("Enter second integer: ");
		number2 = input.nextInt();
		input.close();

		sum = number1 + number2;
		mul = number1 * number2;
		sub = number1 - number2;
		div = number1 / number2;

		System.out.printf("Sum is %d%n", sum);
		System.out.printf("Product is %d%n", mul);
		System.out.printf("Difference is %d%n", sub);
		System.out.printf("Quotient is %d%n", div);
	}
}