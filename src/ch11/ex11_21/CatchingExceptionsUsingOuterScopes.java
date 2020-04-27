/* 11.21 (Catching Exceptions Using Outer Scopes) Write a program
showing that a method with its own try block does not have to catch
every possible error generated within the try. Some exceptions can slip
through to, and be handled in, other scopes. */

package ch11.ex11_21;

public class CatchingExceptionsUsingOuterScopes {

	public static void main(String[] args) {
		try {
			doSomething("10");
			doSomething("InvalidInt-10");
			doSomething("0");
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException handled in main");
		}
	}

	public static void doSomething(String numberString) {
		try {
			int number = Integer.parseInt(numberString);

			System.out.println(100 / number);
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException handled in doSomething");
		}
	}

}
