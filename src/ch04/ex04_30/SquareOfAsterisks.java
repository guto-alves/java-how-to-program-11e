/* 4.30 (Square of Asterisks) Write an application that prompts the user to
enter the size of the side of a square, then displays a hollow square of that
size made of asterisks. Your program should work for squares of all side
lengths between 1 and 20. */

package ch04.ex04_30;

import java.util.Scanner;

public class SquareOfAsterisks {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the size of the side of a square: ");
		int sideSize = scanner.nextInt();
		scanner.close();

		int i = 0;

		while (i++ < sideSize) {
			int j = 0;

			while (j++ < sideSize)
				System.out.print("*");

			System.out.println();
		}
	}

}
