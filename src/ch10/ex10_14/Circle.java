package ch10.ex10_14;

public class Circle extends TwoDimensionalShape {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public String toString() {
		return String.format("%s: %n%s = %.2f", "Circle", "radius", getRadius());
	}
}
