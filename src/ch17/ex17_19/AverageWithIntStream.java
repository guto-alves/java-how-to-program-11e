/* 17.19 (Calculating the Class Average with an IntStream) Figures 4.8
and 4.10 demonstrated calculating a class average with counter-controlled
repetition and sentinel-controlled repetition, respectively. Create a
program that reads integer grades and stores them in an ArrayList, then
use stream processing to perform the average calculation. */

package ch17.ex17_19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageWithIntStream {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		List<Integer> grades = new ArrayList<>();

		while (input.hasNext()) {
			grades.add(input.nextInt());
		}

		input.close();

		System.out.printf("Average: %.1f", 
				grades.stream()
					.mapToInt(Integer::intValue)
					.average()
					.orElse(0));
	}

}
