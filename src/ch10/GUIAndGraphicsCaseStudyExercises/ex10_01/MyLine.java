package ch10.GUIAndGraphicsCaseStudyExercises.ex10_01;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyLine extends MyShape {

	public MyLine() {
		super();
	}

	public MyLine(double x1, double y1, double x2, double y2, Color strokeColor) {
		super(x1, y1, x2, y2, strokeColor);
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.setStroke(getStrokeColor());
		gc.strokeLine(getX1(), getY1(), getX2(), getY2());
	}
}