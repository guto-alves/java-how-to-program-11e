// Fig. 8.17: MyLine.java
// MyLine class represents a line.

package ch08.GUIAndGraphicsCaseStudyExercises.ex08_01;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyLine {
	private double x1; // x-coordinate of first endpoint
	private double y1; // y-coordinate of first endpoint
	private double x2; // x-coordinate of second endpoint
	private double y2; // y-coordinate of second endpoint
	private Color strokeColor; // color of this line
	private double thicknesses;

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
		gc.setLineWidth(thicknesses);
		gc.setStroke(strokeColor);
		gc.strokeLine(x1, y1, x2, y2);
	}
}