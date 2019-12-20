package ch08.ex08_11;

public class ComplexTest {

	public static void main(String[] args) {
		Complex complex1 = new Complex(4, 5);
		Complex complex2 = new Complex(-1, 3);

		System.out.printf("%s + %s = %s%n%n", complex1, complex2, Complex.add(complex1, complex2));
		System.out.printf("%s - %s = %s%n", complex1, complex2, Complex.subtract(complex1, complex2));
	}

}
