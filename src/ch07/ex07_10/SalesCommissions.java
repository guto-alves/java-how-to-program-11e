/* 7.10 (Sales Commissions) Use a one-dimensional array to solve the
following problem: A company pays its salespeople on a commission
basis. The salespeople receive $200 per week plus 9% of their gross sales
for that week. For example, a salesperson who grosses $5,000 in sales in a
week receives $200 plus 9% of $5,000, or a total of $650. Write an
application (using an array of counters) that determines how many of the
salespeople earned salaries in each of the following ranges (assume that
each salesperson’s salary is truncated to an integer amount):

	1. $200–299
	2. $300–399
	3. $400–499
	4. $500–599
	5. $600–699
	6. $700–799
	7. $800–899
	8. $900–999
	9. $1,000 and over

Summarize the results in tabular format. */

package ch07.ex07_10;

import java.util.ArrayList;
import java.util.Scanner;

public class SalesCommissions {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ArrayList<Integer> salaries = new ArrayList<>();

		int grossSales = 0;

		while (grossSales != -1) {
			System.out.print("Gross sales in the week or -1 to quit: ");
			grossSales = scanner.nextInt();

			if (grossSales != -1)
				salaries.add((int) (200 + (0.09 * grossSales)));
		}
		scanner.close();

		displayRanges(salaries);
	}

	public static void displayRanges(ArrayList<Integer> salaries) {
		System.out.println("\nFrequency of wages at each of the following intervals:");
		int[] frequency = new int[11];

		for (Integer salary : salaries) {
			int rangeIndex = salary / 100;
			++frequency[rangeIndex > 10 ? 10 : rangeIndex];
		}

		for (int i = 2; i < frequency.length; i++) {
			/*
			 * 1. $200–299 2. $300–399
			 */

			if (i == 10)
				System.out.printf("$%d %s: ", 1000, "and over");
			else
				System.out.printf("$%d-%d: ", i * 100, i * 100 + 99);

			for (int starts = 0; starts < frequency[i]; starts++)
				System.out.print("*");

			System.out.println();
		}
	}

}
