/* 5.11 (Find the Smallest Value) Write an application that finds the smallest
of several integers. Assume that the first value read specifies the number
of values to input from the user. */

package ch05.ex05_11;

import java.util.Scanner;

public class SmallestValue {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of values to input: ");
		int totalValues = scanner.nextInt();

		int smallest = 0;

		for (int i = 0; i < totalValues; i++) {
			System.out.print("Enter a integer: ");
			int number = scanner.nextInt();

			if (i == 0)
				smallest = number;

			if (number < smallest)
				smallest = number;
		}

		scanner.close();

		if (totalValues > 0)
			System.out.printf("%nSmallest is %d", smallest);
		else
			System.out.println("\nNo values were entered");
	}

}
