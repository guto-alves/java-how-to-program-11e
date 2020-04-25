/* 17.16 (IntStream Filtering and Sorting) Use SecureRandom
method ints to generate a stream of 50 random numbers in the range 1 to
999, then filter the resulting stream elements to select only the odd
numbers and display the results in sorted order. */

package ch17.ex17_16;

import java.security.SecureRandom;
import java.util.stream.Collectors;

public class IntSreamFilteringAndSorting {

	public static void main(String[] args) {
		SecureRandom random = new SecureRandom();

		System.out.print(random.ints(50, 1, 1000)
			  .filter(x -> x % 2 != 0)
			  .sorted()
			  .mapToObj(String::valueOf)
			  .collect(Collectors.joining(" ")));
	}

}
