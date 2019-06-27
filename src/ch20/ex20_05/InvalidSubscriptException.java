package ch20.ex20_05;

public class InvalidSubscriptException extends RuntimeException {

	public InvalidSubscriptException() {
		this("Subscript Exception");
	}

	public InvalidSubscriptException(String message) {
		super(message);
	}
}
