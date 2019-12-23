package ch10.ex10_14;

public class Sphere extends ThreeDimensionalShape {
	private double radius;

	public Sphere(double radius) {
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
		return 4 * Math.PI * Math.pow(radius, 2);
	}

	@Override
	public double getVolume() {
		return 4 * Math.PI * Math.pow(radius, 3) / 3;
	}

	@Override
	public String toString() {
		return String.format("%s: %n%s = %.2f", "Sphere", "radius", getRadius());
	}
}
