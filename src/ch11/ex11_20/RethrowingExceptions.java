package ch11.ex11_20;

public class RethrowingExceptions {

	public static void main(String[] args) {
		try {
			someMethod();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void someMethod() throws Exception {
		try {
			someMethod2();
		} catch (Exception e) {
			throw new Exception("Exception thrown in someMethod");
		}
	}

	public static void someMethod2() throws Exception {
		throw new Exception("Exception thrown in someMethod2");
	}

}
