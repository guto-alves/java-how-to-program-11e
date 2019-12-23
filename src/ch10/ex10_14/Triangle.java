package ch10.ex10_14;

public class Triangle extends TwoDimensionalShape {
	private double base;
	private double height;

	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double getArea() {
		return base * height / 2;
	}

	@Override
	public String toString() {
		return String.format("%s: %n%s = %.2f%n%s = %.2f", "Square", "base", getBase(), "height", getHeight());
	}
}
