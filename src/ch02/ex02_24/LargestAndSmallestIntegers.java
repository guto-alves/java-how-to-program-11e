/*
 * 2.24 (Largest and Smallest Integers) Write an application that reads five
 * integers and determines and prints the largest and smallest integers in the
 * group. Use only the programming techniques you learned in this chapter.
 */

package ch02.ex02_24;

import java.util.Scanner;

public class LargestAndSmallestIntegers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int number1, number2, number3, number4, number5;
		int largest, smallest;

		System.out.print("Enter first integer: ");
		number1 = input.nextInt();

		System.out.print("Enter second integer: ");
		number2 = input.nextInt();

		System.out.print("Enter third integer: ");
		number3 = input.nextInt();

		System.out.print("Enter fourth integer: ");
		number4 = input.nextInt();

		System.out.print("Enter fifth integer: ");
		number5 = input.nextInt();
		input.close();

		largest = number1;
		if (number2 > largest)
			largest = number2;
		if (number3 > largest)
			largest = number3;
		if (number4 > largest)
			largest = number4;
		if (number5 > largest)
			largest = number5;

		smallest = number1;
		if (number2 < smallest)
			smallest = number2;
		if (number3 < smallest)
			smallest = number3;
		if (number3 > smallest)
			smallest = number3;
		if (number4 < smallest)
			smallest = number4;
		if (number5 < smallest)
			smallest = number5;

		System.out.printf("Largest is %d%n", largest);
		System.out.printf("Smallest is %d%n", smallest);
	}
}