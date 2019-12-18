/* Write an application that estimates the value of the mathematical
constant e by using the following formula. Allow the user to
enter the number of terms to calculate.
 		 e  = 1 + (1 / 1!) + (1 / 2!) + (1 / 3!) + ...
 */

package ch04.ex04_38;

import java.util.Scanner;

public class FactorialB {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int numberOfTerms;

		System.out.print("Enter number of terms: ");
		numberOfTerms = scanner.nextInt();
		scanner.close();

		double result = 0;
		int termsCounter = 0;

		while (termsCounter < numberOfTerms) {

			int auxCounter = termsCounter;
			double factorial = 1;
			while (auxCounter > 1) {
				factorial *= auxCounter;
				auxCounter--;
			}

			result += 1 / factorial;

			termsCounter++;
		}

		System.out.printf("e = %f", result);
	}
}
