/* 17.20 (Mapping Integer Grades to Letter Grades) Create a program that
reads integer grades and stores them in an ArrayList, then use stream
processing to display each grade’s letter equivalent (A, B, C, D or F). */

package ch17.ex17_20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AverageWithIntStream {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		List<Integer> grades = new ArrayList<>();

		while (input.hasNext()) {
			grades.add(input.nextInt());
		}

		input.close();

		System.out.printf("%s", 
				grades.stream()
					.map(grade -> 
						  (grade >= 90) ? "A" :
					      (grade >= 80) ? "B" :
					      (grade >= 70) ? "C" :
					      (grade >= 60) ? "D" : "F"
					)
					.collect(Collectors.joining(" ")));
	}

}
