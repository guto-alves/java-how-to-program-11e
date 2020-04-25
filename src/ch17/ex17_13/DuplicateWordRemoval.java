/* 17.13 (Duplicate Word Removal) Write a program that inputs a sentence
from the user (assume no punctuation), then determines and displays the
unique words in alphabetical order. Treat uppercase and lowercase letters
the same. */

package ch17.ex17_13;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DuplicateWordRemoval {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter a sentence: ");
		String sentence = input.nextLine();
		input.close();

		System.out.printf("Unique words in alphabetical order: %s",
				Arrays.stream(sentence.split(" "))
					.map(String::toLowerCase)
					.distinct()
					.sorted()
					.collect(Collectors.joining(" ")));
	}

}
