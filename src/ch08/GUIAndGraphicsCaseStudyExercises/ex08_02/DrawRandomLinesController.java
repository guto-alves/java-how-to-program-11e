package ch08.GUIAndGraphicsCaseStudyExercises.ex08_02;

import java.security.SecureRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawRandomLinesController {
	private static final SecureRandom randomNumbers = new SecureRandom();

	@FXML
	private Canvas canvas;

	@FXML
	void drawRectanglesButtonPressed(ActionEvent event) {
		// get the GraphicsContext, which is used to draw on the Canvas
		GraphicsContext gc = canvas.getGraphicsContext2D();

		MyRectangle[] rectangles = new MyRectangle[100]; // stores the MyLine objects

		final int width = (int) canvas.getWidth();
		final int height = (int) canvas.getHeight();

		// create lines
		for (int count = 0; count < rectangles.length; count++) {
			// generate random coordinates
			int x1 = randomNumbers.nextInt(width);
			int y1 = randomNumbers.nextInt(height);
			int x2 = randomNumbers.nextInt(width);
			int y2 = randomNumbers.nextInt(height);

			// generate a random color
			Color strokeColor = Color.rgb(randomNumbers.nextInt(256), randomNumbers.nextInt(256),
					randomNumbers.nextInt(256));

			// generate a random thicknesses
			double thicknesses = 1 + randomNumbers.nextInt(10);

			Color fillColor = Color.rgb(randomNumbers.nextInt(256), randomNumbers.nextInt(256),
					randomNumbers.nextInt(256));

			// add a new MyLine to the array
			rectangles[count] = new MyRectangle(x1, y1, x2, y2, strokeColor, thicknesses, fillColor,
					randomNumbers.nextInt(2) == 0);
		}

		// clear the Canvas then draw the lines
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		for (MyRectangle rectangle : rectangles)
			rectangle.draw(gc);
	}

	@FXML
	void drawOvalsButtonPressed(ActionEvent event) {
		GraphicsContext gc = canvas.getGraphicsContext2D();

		MyOval[] ovals = new MyOval[100];

		final int width = (int) canvas.getWidth();
		final int height = (int) canvas.getHeight();

		for (int count = 0; count < ovals.length; count++) {
			// generate random coordinates
			int x1 = randomNumbers.nextInt(width);
			int y1 = randomNumbers.nextInt(height);
			int x2 = randomNumbers.nextInt(width);
			int y2 = randomNumbers.nextInt(height);

			// generate a random color
			Color color = Color.rgb(randomNumbers.nextInt(256), randomNumbers.nextInt(256), randomNumbers.nextInt(256));

			// generate a random thicknesses
			double thicknesses = 1 + randomNumbers.nextInt(10);

			Color fillColor = Color.rgb(randomNumbers.nextInt(256), randomNumbers.nextInt(256),
					randomNumbers.nextInt(256));
			
			// add a new MyLine to the array
			ovals[count] = new MyOval(x1, y1, x2, y2, color, thicknesses, fillColor,
					randomNumbers.nextInt(2) == 0);
		}

		// clear the Canvas then draw the lines
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		for (MyOval oval : ovals)
			oval.draw(gc);
	}
}