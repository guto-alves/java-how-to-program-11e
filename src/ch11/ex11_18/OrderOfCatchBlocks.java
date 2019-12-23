/* 11.18 (Order of catch Blocks) Write a program demonstrating that the
order of catch blocks is important. If you try to catch a superclass
exception type before a subclass type, the compiler should generate errors. */

package ch11.ex11_18;

public class OrderOfCatchBlocks {

	public static void main(String[] args) {
		try {
			int n = 10 / 0;
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

//		Unreachable catch block for ArithmeticException. It is already handled by the catch block for Exception
//		try {
//			int n = 10 / 0;
//		} catch (Exception e) {
//			e.printStackTrace();
//		} catch (ArithmeticException e) {
//			e.printStackTrace();
//		}
	}

}
