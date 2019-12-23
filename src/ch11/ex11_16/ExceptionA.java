package ch11.ex11_16;

public class ExceptionA extends Exception {

	public ExceptionA() {
		super("Exception A");
	}

	public ExceptionA(String message) {
		super(message);
	}
}
