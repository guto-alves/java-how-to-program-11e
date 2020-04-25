/* 17.14 (Sorting Letters and Removing Duplicates) Write a program that
inserts 30 random letters into a List<Character>. Perform the
following operations and display your results:
1. Sort the List in ascending order.
2. Sort the List in descending order.
3. Display the List in ascending order with duplicates removed. */

package ch17.ex17_14;

import java.security.SecureRandom;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortingLettersAndRemovingDuplicates {

	public static void main(String[] args) {
		SecureRandom random = new SecureRandom();
	
		List<Character> letters = Stream.generate(() -> 65 + random.nextInt(26))
			.map(x -> (char) (int) x)
			.limit(30)
			.collect(Collectors.toList());
		
		letters.stream()
				.sorted()
				.forEach(letter -> System.out.printf("%s ", letter));
		
		System.out.println();
		
		letters.stream()
			.sorted(Comparator.reverseOrder())
			.forEach(letter -> System.out.printf("%s ", letter));
		
		System.out.println();
		
		letters.stream()
				.sorted()
				.distinct()
				.forEach(letter -> System.out.printf("%s ", letter));
	}

}
