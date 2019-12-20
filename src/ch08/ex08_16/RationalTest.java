package ch08.ex08_16;

public class RationalTest {

	public static void main(String[] args) {
		Rational rational1 = new Rational(3, 8);
		Rational rational2 = new Rational(5, 12);

		System.out.println("Operations:");
		System.out.printf("%s + %s = %s%n", rational1, rational2, Rational.add(rational1, rational2));
		System.out.printf("%s - %s = %s%n", rational1, rational2, Rational.subtract(rational1, rational2));
		System.out.printf("%s x %s = %s%n", rational1, rational2, Rational.multiply(rational1, rational2));
		System.out.printf("%s / %s = %s%n", rational1, rational2, Rational.divide(rational1, rational2));
	}

}
