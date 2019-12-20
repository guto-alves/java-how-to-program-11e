package ch08.GUIAndGraphicsCaseStudyExercises.ex08_02;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyOval {
	private double x1; // x-coordinate of first endpoint
	private double y1; // y-coordinate of first endpoint
	private double x2; // x-coordinate of second endpoint
	private double y2; // y-coordinate of second endpoint
	private Color strokeColor; // color of this line
	private double thicknesses;

	private Color fillColor;
	private boolean filled;

	public MyOval() {
		this(0, 0, 0, 0, Color.BLACK, 1, Color.BLACK, false);
	}

	// constructor with input values
	public MyOval(double x1, double y1, double x2, double y2, Color strokeColor, double thicknesses, Color fillColor,
			boolean filled) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.strokeColor = strokeColor;
		this.thicknesses = thicknesses;

		this.fillColor = fillColor;
		this.filled = filled;
	}

	public double getUpperLeftX() {
		return x1 < x2 ? x1 : x2;
	}

	public double getUpperLeftY() {
		return y1 < y2 ? y1 : y2;
	}

	public double getWidth() {
		return Math.abs(x1 - x2);
	}

	public double getHeight() {
		return Math.abs(y1 - y2);
	}

	public double getThicknesses() {
		return thicknesses;
	}

	public void setThicknesses(double thicknesses) {
		this.thicknesses = thicknesses;
	}

	public Color getStrokeColor() {
		return strokeColor;
	}

	public void setStrokeColor(Color strokeColor) {
		this.strokeColor = strokeColor;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public void draw(GraphicsContext gc) {
		gc.setLineWidth(getThicknesses());
		gc.setStroke(getStrokeColor());
		gc.setFill(getFillColor());

		if (isFilled())
			gc.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		else
			gc.strokeOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
	}
}