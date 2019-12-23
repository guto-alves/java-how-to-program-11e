package ch10.ex10_15;

public class PieceWorker extends Employee {
	private double wage;
	private int pieces;

	public PieceWorker(String firstName, String lastName, String socialSecurityNumber, double wage, int pieces) {
		super(firstName, lastName, socialSecurityNumber);

		if (wage < 0.0) {
			throw new IllegalArgumentException("Wage per piece must be >= 0.0");
		}

		if (pieces < 0) {
			throw new IllegalArgumentException("Number of piece must be >= 0");
		}

		this.wage = wage;
		this.pieces = pieces;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		if (wage < 0.0) {
			throw new IllegalArgumentException("Wage per piece must be >= 0.0");
		}

		this.wage = wage;
	}

	public int getPieces() {
		return pieces;
	}

	public void setPieces(int pieces) {
		this.pieces = pieces;
	}

	@Override
	public double earnings() {
		return getWage() * getPieces();
	}

	@Override
	public String toString() {
		return String.format("piece worker: %s%n%s: $%,.2f; %s: %d", super.toString(), "piece wage", getWage(),
				"number of pieces", getPieces());
	}
}
