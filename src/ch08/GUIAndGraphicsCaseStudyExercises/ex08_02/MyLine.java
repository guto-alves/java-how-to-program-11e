package ch08.GUIAndGraphicsCaseStudyExercises.ex08_02;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyLine {
	private double x1; // x-coordinate of first endpoint
	private double y1; // y-coordinate of first endpoint
	private double x2; // x-coordinate of second endpoint
	private double y2; // y-coordinate of second endpoint
	private Color strokeColor; // color of this line
	private double thicknesses;

	public MyLine() {
		this(0, 0, 0, 0, Color.BLACK, 1);
	}

	// constructor with input values
	public MyLine(double x1, double y1, double x2, double y2, Color strokeColor, double thicknesses) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.strokeColor = strokeColor;
		this.thicknesses = thicknesses;
	}

	// draw the line in the specified color
	public void draw(GraphicsContext gc) {
		gc.setLineWidth(getThicknesses());
		gc.setStroke(getStrokeColor());
		gc.strokeLine(getX1(), getY1(), getX2(), getY2());
	}

	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1 >= 0 ? x1 : 0;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1 >= 0 ? y1 : 0;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2 >= 0 ? x2 : 0;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2 >= 0 ? y2 : 0;
	}

	public Color getStrokeColor() {
		return strokeColor;
	}

	public void setStrokeColor(Color strokeColor) {
		this.strokeColor = strokeColor;
	}

	public double getThicknesses() {
		return thicknesses;
	}

	public void setThicknesses(double thicknesses) {
		this.thicknesses = thicknesses;
	}
}