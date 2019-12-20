package ch08.ex08_13;

public class IntegerSetTest {

	public static void main(String[] args) {
		IntegerSet integerSet = new IntegerSet();

		for (boolean n : integerSet.getSet())
			System.out.println(n);
	}

}
