/* 11.19 (Constructor Failure) Write a program that shows a constructor
passing information about constructor failure to an exception handler.
Define class SomeClass, which throws an Exception in the
constructor. Your program should try to create an object of type
SomeClass and catch the exception that’s thrown from the constructor. */

package ch11.ex11_19;

public class SomeClassTest {

	public static void main(String[] args) {
		try {
			new SomeClass(-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
