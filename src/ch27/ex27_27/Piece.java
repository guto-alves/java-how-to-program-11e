package ch27.ex27_27;

import java.awt.Color;
import java.security.SecureRandom;

public class Piece {
	private final SecureRandom random = new SecureRandom();
	private double value;
	private double percentage;
	private Color color;

	public Piece() {
		this(0);
	}

	public Piece(double value) {
		this.value = value;
		this.color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
	}

	public Piece(double value, Color color) {
		this.value = value;
		this.color = color;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
