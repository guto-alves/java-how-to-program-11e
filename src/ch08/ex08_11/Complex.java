package ch08.ex08_11;

public class Complex {
	private double realPart;
	private double imaginaryPart;

	public Complex() {
		this(1, 1);
	}

	public Complex(double realPart, double imaginaryPart) {
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}

	public double getRealPart() {
		return realPart;
	}

	public double getImaginaryPart() {
		return imaginaryPart;
	}

	public static Complex add(Complex complexNumber1, Complex complexNumber2) {
		return new Complex(complexNumber1.getRealPart() + complexNumber2.getRealPart(),
				complexNumber1.getImaginaryPart() + complexNumber2.getImaginaryPart());
	}

	public static Complex subtract(Complex complexNumber1, Complex complexNumber2) {
		return new Complex(complexNumber1.getRealPart() - complexNumber2.getRealPart(),
				complexNumber1.getImaginaryPart() - complexNumber2.getImaginaryPart());
	}

	@Override
	public String toString() {
		return String.format("(%.0f, %.0fi)", getRealPart(), getImaginaryPart());
	}
}
