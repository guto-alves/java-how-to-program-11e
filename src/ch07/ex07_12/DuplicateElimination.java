/* 7.12 (Duplicate Elimination) Use a one-dimensional array to solve the
following problem: Write an application that inputs five numbers, each
between 10 and 100, inclusive. As each number is read, display it only if
it’s not a duplicate of a number already read. Provide for the “worst case,”
in which all five numbers are different. Use the smallest possible array to
solve this problem. Display the complete set of unique values input after
the user enters each new value. */

package ch07.ex07_12;

import java.util.Scanner;

public class DuplicateElimination {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] array = new int[5];

		for (int i = 0; i < array.length; i++) {
			System.out.print("Enter an integer between 10 and 100: ");
			array[i] = scanner.nextInt();

			displayEliminatingDuplicates(array, i);
		}

		scanner.close();
	}

	public static void displayEliminatingDuplicates(int[] array, int delimiterIndex) {
		System.out.print("\nUnique values: ");

		for (int i = 0; i <= delimiterIndex; i++) {
			boolean unique = true;

			for (int j = i + 1; j <= delimiterIndex; j++) {
				if (array[j] == array[i]) {
					unique = false;
					break;
				}
			}
			
			if (unique) {
				for (int j = 0; j < i; j++) {
					if (array[j] == array[i]) {
						unique = false;
						break;
					}
				}
			}

			if (unique)
				System.out.printf("%d ", array[i]);
		}

		System.out.println("\n");
	}

}
