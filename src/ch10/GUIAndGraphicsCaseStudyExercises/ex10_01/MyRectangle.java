package ch10.GUIAndGraphicsCaseStudyExercises.ex10_01;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyRectangle extends MyShape {
	private boolean filled;
	private Color fillColor;

	public MyRectangle() {
		this(0, 0, 0, 0, Color.BLACK, false, Color.BLACK);
	}

	public MyRectangle(double x1, double y1, double x2, double y2, Color strokeColor, boolean filled, Color fillColor) {
		super(x1, y1, x2, y2, strokeColor);

		this.filled = filled;
		this.fillColor = fillColor;
	}

	public double getUpperLeftX() {
		return getX1() < getX2() ? getX1() : getX2();
	}

	public double getUpperLeftY() {
		return getY1() < getY2() ? getY1() : getY2();
	}

	public double getWidth() {
		return Math.abs(getX1() - getX2());
	}

	public double getHeight() {
		return Math.abs(getY1() - getY2());
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public void draw(GraphicsContext gc) {
		gc.setStroke(getStrokeColor());
		gc.setFill(getFillColor());

		if (isFilled())
			gc.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		else
			gc.strokeRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
	}
}