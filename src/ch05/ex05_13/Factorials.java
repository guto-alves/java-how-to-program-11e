/* 5.13 (Factorials) Factorials are used frequently in probability problems.
The factorial of a positive integer n (written n! and pronounced “n
factorial”) is equal to the product of the positive integers from 1 to n.
Write an application that calculates the factorials of 1 through 20. Use type
long. Display the results in tabular format. What difficulty might prevent
you from calculating the factorial of 100? */

package ch05.ex05_13;

public class Factorials {

	public static void main(String[] args) {
		for (int i = 1; i <= 20; i++) {

			long factorial = 1;
			for (int j = i; j > 1; j--)
				factorial *= j;

			System.out.printf("%d! = %d%n", i, factorial);
		}
	}
}
