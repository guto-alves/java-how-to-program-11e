/* 6.17 (Even or Odd) Write a method isEven that uses the remainder
operator (%) to determine whether an integer is even. The method should
take an integer argument and return true if the integer is even and
false otherwise. Incorporate this method into an application that inputs
a sequence of integers (one at a time) and determines whether each is even
or odd. */

package ch06.ex06_17;

import java.util.Scanner;

public class EvenOrOdd {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter an integer: ");
		int number = scanner.nextInt();
		scanner.close();

		System.out.printf("%nIs %d even? %s", number, isEven(number));
	}

	public static boolean isEven(int number) {
		return number % 2 == 0 ? true : false;
	}

}
