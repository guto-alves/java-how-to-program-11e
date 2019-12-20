package ch08.ex08_16;

public class Rational {
	private int numerator;
	private int denominator;

	public Rational() {
		this(1, 1);
	}

	public Rational(int numerator, int denominator) {
		int gcd = gcd(numerator, denominator);
		this.numerator = numerator / gcd;
		this.denominator = denominator / gcd;
	}

	public static Rational add(Rational rational1, Rational rational2) {
		return new Rational(
				rational1.getNumerator() * rational2.getDenominator()
						+ rational2.getNumerator() * rational1.getDenominator(),
				rational1.getDenominator() * rational2.getDenominator());
	}

	public static Rational subtract(Rational rational1, Rational rational2) {
		return new Rational(
				rational1.getNumerator() * rational2.getDenominator()
						- rational2.getNumerator() * rational1.getDenominator(),
				rational1.getDenominator() * rational2.getDenominator());
	}

	public static Rational multiply(Rational rational1, Rational rational2) {
		return new Rational(rational1.getNumerator() * rational2.getNumerator(),
				rational1.getDenominator() * rational2.getDenominator());
	}

	public static Rational divide(Rational rational1, Rational rational2) {
		return new Rational(rational1.getNumerator() * rational2.getDenominator(),
				rational1.getDenominator() * rational2.getNumerator());
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	public String toFloatingPoint() {
		return String.format("%f", getNumerator() / getDenominator());
	}

	@Override
	public String toString() {
		return String.format("%s/%s", getNumerator(), getDenominator());
	}

	public int gcd(int x, int y) {
		return y == 0 ? x : gcd(y, x % y);
	}
}
