package ch08.ex08_17;

public class HugeIntegerTest {

	public static void main(String[] args) {
		HugeInteger integer1 = new HugeInteger("5");
		HugeInteger integer2 = new HugeInteger("5");

		System.out.printf("%s + %s = %s%n", integer1, integer2, integer1.add(integer2));
		System.out.printf("%s - %s = %s%n", integer1, integer2, integer1.subtract(integer2));
	}

}
