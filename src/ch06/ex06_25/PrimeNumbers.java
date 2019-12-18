/* 6.25 (Prime Numbers)A positive integer is prime if it’s divisible by only 1
and itself. For example, 2, 3, 5 and 7 are prime, but 4, 6, 8 and 9 are not.
The number 1, by definition, is not prime.

1. Write a method that determines whether a number is prime.

2. Use this method in an application that determines and displays all
the prime numbers less than 10,000. How many numbers up to
10,000 do you have to test to ensure that you’ve found all the
primes?

3. Initially, you might think that n/2 is the upper limit for which you
must test to see whether a number n is prime, but you need only
go as high as the square root of n. Rewrite the program, and run it
both ways. */

package ch06.ex06_25;

import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter an integer: ");
		int number = scanner.nextInt();
		scanner.close();

		if (isPrime(number))
			System.out.printf("%n%d is prime", number);
		else
			System.out.printf("%n%d is not prime", number);
	}

	public static boolean isPrime(int number) {
		if (number < 2)
			return false;

		if (number % 2 == 0 && number > 2)
			return false;

		int root = (int) Math.sqrt(number);

		for (int i = 2; i <= root; i++) {
			if (number % i == 0)
				return false;
		}

		return true;
	}
	
}
