/* 17.24 (Infinite Streams of Prime Integers) Use an infinite stream of
integers to display the first n prime numbers, where n is input by the user.*/

package ch17.ex17_24;

import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class InfiniteStreamOfPrimeNumbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int n = input.nextInt();
		input.close();
		
		IntPredicate primeNumber = (number) -> {
				if (number != 2 && number % 2 == 0) {
					return false;
				}
				
				return IntStream.rangeClosed(3, (int) Math.sqrt(number))
					.filter(x -> x % 2 != 0)
					.noneMatch(x -> number % x == 0);
			};
		
		IntStream.iterate(2, x -> ++x)
			.filter(primeNumber)
			.limit(n)
			.forEach(System.out::println);
	}
	

}
