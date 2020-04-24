/* 7.16 (Using the Enhanced for Statement) Write an application that uses
an enhanced for statement to sum the double values passed by the
command-line arguments. [Hint:Use the static method
parseDouble of class Double to convert a String to a double
value.] */

package ch07.ex07_16;

public class Foreach {

	public static void main(String[] args) {
		double sum = 0.0;

		for (String arg : args) {
			sum += Double.parseDouble(arg);
		}

		System.out.printf("Sum is %.2f%n", sum);
	}

}
