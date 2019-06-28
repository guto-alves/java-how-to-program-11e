package ch08.ex08_04;

public class Rectangle {
	private double width;
	private double length;

	public Rectangle() {
		this(1, 1);
	}

	public Rectangle(int width, int length) {
		this.setWidth(width);
		this.setLength(length);
	}

	public double area() {
		return getWidth() * getLength();
	}

	public double perimiter() {
		return 2 * (getWidth() + getLength());
	}

	public void setWidth(double width) {
		if (width <= 0.0 || width >= 20.0)
			throw new IllegalArgumentException("width must be between 0 and 20");

		this.width = width;
	}

	public void setLength(double length) {
		if (length <= 0.0 || length >= 20.0)
			throw new IllegalArgumentException("length must be between 0 and 20");

		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public double getLength() {
		return length;
	}

	public String toString() {
		return String.format("Rectangle%nWidth: %,.1f%nLength: %,.1f%n", getWidth(), getLength());
	}
}
