package ch11.ex11_19;

public class SomeClass {
	private int number;

	public SomeClass(int number) throws Exception {
		if (number < 0)
			throw new Exception("Number must be greater than or equal to zero");

		this.number = number;
	}
}
