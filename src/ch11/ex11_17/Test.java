/* 11.17 (Catching Exceptions Using Class Exception) Write a program
that demonstrates how various exceptions are caught with
catch (Exception exception)
This time, define classes ExceptionA (which inherits from class
Exception) and ExceptionB (which inherits from class
ExceptionA). In your program, create try blocks that throw
exceptions of types ExceptionA, ExceptionB,
NullPointerException and IOException. All exceptions should
be caught with catch blocks specifying type Exception. */

package ch11.ex11_17;

import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		try {
			throw new ExceptionA("Exception A");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			throw new ExceptionB("Exception B");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			throw new NullPointerException();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			throw new IOException();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
