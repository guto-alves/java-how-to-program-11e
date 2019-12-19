package ch07.GUIAndGraphicsCaseStudyExercises.ex07_01;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawSpiralLinesController {
	@FXML
	private Canvas canvas;

	@FXML
	void onDrawSpiralButtonPressed(ActionEvent event) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.GREEN);

		int lineLength = 29;

		int direction = 0;

		double x1 = canvas.getWidth() / 2, y1 = canvas.getHeight() / 2;
		double x2 = canvas.getWidth() / 2, y2 = canvas.getHeight() / 2 + lineLength;

		int lineCount = 0;

		gc.strokeLine(x1, y1, x2, y2); // down

		while (lineLength < canvas.getWidth()) {
			if (lineCount == 1)
				lineLength += 30;

			lineCount = (lineCount + 1) % 2;

			switch (direction) {
			case 0: // left
				x1 = x2;
				y1 = y2;
				x2 = x1 - lineLength;
				break;
			case 1: // up
				x1 = x2;
				y1 = y2;

				y2 = y1 - lineLength;
				break;
			case 2: // right
				x1 = x2;
				y1 = y2;
				x2 = x1 + lineLength;
				break;
			case 3: // down
				x1 = x2;
				y1 = y2;
				y2 = y1 + lineLength;
				break;
			}
			
			gc.strokeLine(x1, y1, x2, y2);

			direction = (direction + 1) % 4;
		}
	}

}
