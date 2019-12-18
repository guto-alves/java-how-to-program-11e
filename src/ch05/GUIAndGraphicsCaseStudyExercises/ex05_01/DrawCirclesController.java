package ch05.GUIAndGraphicsCaseStudyExercises.ex05_01;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class DrawCirclesController {
	@FXML
	private Canvas canvas;

	@FXML
	void drawCirclesButtonPressed(ActionEvent event) {
		drawCircles();
	}

	public void drawCircles() {
		GraphicsContext gc = canvas.getGraphicsContext2D();

		for (int i = 0; i < 12; i++)
			gc.strokeOval(canvas.getWidth() / 2 - 10 * i - 10, canvas.getHeight() / 2 - 10 * i - 10, 10 + 20 * i, 10 + 20 * i);
	}

}
