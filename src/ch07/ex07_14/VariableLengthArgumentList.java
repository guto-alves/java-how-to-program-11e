/* 7.14 (Variable-Length Argument List) Write an application that calculates
the product of a series of integers that are passed to method product
using a variable-length argument list. Test your method with several calls,
each with a different number of arguments. */

package ch07.ex07_14;

public class VariableLengthArgumentList {

	public static int product(int... numbers) {
		if (numbers.length == 0)
			return 0;

		int total = 1;

		for (int number : numbers)
			total *= number;

		return total;
	}

	public static void main(String[] args) {
		System.out.println(product());
		System.out.println(product(10));
		System.out.println(product(10, 10));
		System.out.println(product(10, 10, 10));
		System.out.println(product(10, 10, 10, 10));
	}
}
