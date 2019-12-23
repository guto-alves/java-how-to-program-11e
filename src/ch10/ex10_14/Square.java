package ch10.ex10_14;

public class Square extends TwoDimensionalShape {
	private double side;

	public Square(double side) {
		this.side = side;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	@Override
	public double getArea() {
		return side * side;
	}

	@Override
	public String toString() {
		return String.format("%s: %n%s = %.2f", "Square", "size", getSide());
	}
}
