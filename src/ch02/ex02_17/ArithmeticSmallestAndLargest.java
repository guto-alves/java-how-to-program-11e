/*
 * 2.17 (Arithmetic, Smallest and Largest) Write an application that inputs
 * three integers from the user and displays the sum, average, product,
 * smallest and largest of the numbers. Use the techniques shown in Fig. 2.15. 
 * [Note: The calculation of the average in this exercise should result in an
 * integer representation of the average. So, if the sum of the values is 7, the
 * average should be 2, not 2.3333….]
 */

package ch02.ex02_17;

import java.util.Scanner;

public class ArithmeticSmallestAndLargest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter first integer: ");
		int number1 = input.nextInt();

		System.out.print("Enter second integer: ");
		int number2 = input.nextInt();

		System.out.print("Enter third integer: ");
		int number3 = input.nextInt();
		input.close();

		int sum = number1 + number2 + number3;
		int average = sum / 3;
		int product = number1 * number2 * number3;

		int largest = number1;
		if (number2 > largest)
			largest = number2;
		if (number3 > largest)
			largest = number3;

		int smallest = number1;
		if (number2 < smallest)
			smallest = number2;
		if (number3 < smallest)
			smallest = number3;

		System.out.printf("Sum is %d%n", sum);
		System.out.printf("Average is %d%n", average);
		System.out.printf("Product is %d%n", product);
		System.out.printf("Largest is %d%n", largest);
		System.out.printf("Smallest is %d%n", smallest);
	}
}