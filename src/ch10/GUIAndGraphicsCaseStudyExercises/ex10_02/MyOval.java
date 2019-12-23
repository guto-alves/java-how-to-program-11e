package ch10.GUIAndGraphicsCaseStudyExercises.ex10_02;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyOval extends MyBoundedShape {

	public MyOval() {
		super();
	}

	public MyOval(double x1, double y1, double x2, double y2, Color strokeColor, boolean filled, Color fillColor) {
		super(x1, y1, x2, y2, strokeColor, filled, fillColor);
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.setStroke(getStrokeColor());
		gc.setFill(getFillColor());

		if (isFilled())
			gc.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		else
			gc.strokeOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
	}
}