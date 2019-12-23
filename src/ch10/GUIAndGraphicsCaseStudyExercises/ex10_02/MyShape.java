package ch10.GUIAndGraphicsCaseStudyExercises.ex10_02;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class MyShape {
	private double x1;
	private double y1;
	private double x2;
	private double y2;
	private Color strokeColor;

	public MyShape() {
		this(0, 0, 0, 0, Color.BLACK);
	}

	public MyShape(double x1, double y1, double x2, double y2, Color strokeColor) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.strokeColor = strokeColor;
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

	public abstract void draw(GraphicsContext gc);

}
