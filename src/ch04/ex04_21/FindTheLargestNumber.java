/* 4.21 (Find the Largest Number) The process of finding the largest value
is used frequently in computer applications. For example, a program that
determines the winner of a sales contest would input the number of units
sold by each salesperson. The salesperson who sells the most units wins
the contest. Write a pseudocode program, then a Java application that
inputs a series of 10 integers and determines and prints the largest integer.
Your program should use at least the following three variables:

1. counter: A counter to count to 10 (i.e., to keep track of how
many numbers have been input and to determine when all 10
numbers have been processed).
2. number: The integer most recently input by the user.
3. largest: The largest number found so far.  */

package ch04.ex04_21;

import java.util.Scanner;

public class FindTheLargestNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int largest = 0;
		int counter = 1;

		while (counter <= 10) {
			System.out.print("Enter a integer: ");
			int number = scanner.nextInt();

			if (counter == 1)
				largest = number;
			else if (number > largest)
				largest = number;

			counter++;
		}

		scanner.close();

		System.out.printf("Largest is %d%n", largest);
	}

}
