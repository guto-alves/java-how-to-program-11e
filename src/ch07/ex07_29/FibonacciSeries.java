/* 7.29 (Fibonacci Series) The Fibonacci series
0, 1, 1, 2, 3, 5, 8, 13, 21, …
begins with the terms 0 and 1 and has the property that each succeeding
term is the sum of the two preceding terms.

1. Write a method fibonacci(n) that calculates the nth
Fibonacci number. Incorporate this method into an application
that enables the user to enter the value of n.

2. Determine the largest Fibonacci number that can be displayed on
your system.

3. Modify the application you wrote in part (a) to use double
instead of int to calculate and return Fibonacci numbers, and
use this modified application to repeat part (b). */

package ch07.ex07_29;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the value of n: ");
		int n = input.nextInt();
		input.close();

		System.out.printf("Fibonacci(%d) = %.0f%n", n, fibonacci(n));
	}

	public static double fibonacci(int nth) {
		double fibonacciNumber = 0;

		double previous = 0;
		double current = 1;

		for (int i = 0; i < nth; i++) {
			if (i < 2) {
				fibonacciNumber = i;
			} else {
				fibonacciNumber = previous + current;
				previous = current;
				current = fibonacciNumber;
			}
		}

		return fibonacciNumber;
	}
}
