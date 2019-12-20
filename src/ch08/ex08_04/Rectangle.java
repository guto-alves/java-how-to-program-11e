package ch08.ex08_04;

public class Rectangle {
	private double length;
	private double width;

	public Rectangle() {
		this(1, 1);
	}

	public Rectangle(int length, int width) {
		this.setLength(length);
		this.setWidth(width);
	}

	public double area() {
		return getWidth() * getLength();
	}

	public double perimiter() {
		return 2 * (getWidth() + getLength());
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		if (length <= 0.0 || length >= 20.0)
			throw new IllegalArgumentException("length must be 0-20");

		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if (width <= 0.0 || width >= 20.0)
			throw new IllegalArgumentException("width must be 0-20");

		this.width = width;
	}

	public String toString() {
		return String.format("Rectangle%nWidth: %,.1f%nLength: %,.1f%n", getWidth(), getLength());
	}
}
