package ch21.ex21_06;

public class EmptyListException extends RuntimeException {

	public EmptyListException() {
		this("List");
	}

	public EmptyListException(String name) {
		super(name + " is empty");
	}
}
