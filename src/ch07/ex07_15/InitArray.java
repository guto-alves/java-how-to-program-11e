/* 7.15 (Command-Line Arguments) Rewrite Fig. 7.2 so that the size of the
array is specified by the first command-line argument. If no command-line
argument is supplied, use 10 as the default size of the array. */

package ch07.ex07_15;

public class InitArray {
	public static void main(String[] args) {
		final int ARRAY_SIZE = args.length > 0 ? Integer.parseInt(args[0]) : 10;

		int[] array = new int[ARRAY_SIZE];

		System.out.printf("%s%8s%n", "Index", "Value");

		for (int counter = 0; counter < array.length; counter++) {
			System.out.printf("%5d%8d%n", counter, array[counter]);
		}
	}
}
