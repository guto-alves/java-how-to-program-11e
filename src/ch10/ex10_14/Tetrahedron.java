package ch10.ex10_14;

public class Tetrahedron extends ThreeDimensionalShape {
	private double edge;

	public Tetrahedron(double edge) {
		this.edge = edge;
	}

	public double getEdge() {
		return edge;
	}

	public void setEdge(double edge) {
		this.edge = edge;
	}

	@Override
	public double getArea() {
		return Math.pow(edge, 2) * Math.sqrt(3);
	}

	@Override
	public double getVolume() {
		return 1.0 / 12 * Math.sqrt(2) * Math.pow(edge, 3);
	}

	@Override
	public String toString() {
		return String.format("%s: %n%s = %.2f", "Tetrahedron", "edge", getEdge());
	}
}
