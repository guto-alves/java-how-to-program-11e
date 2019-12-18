package ch06.GUIAndGraphicsCaseStudyExercises.ex06_02;

import java.security.SecureRandom;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawShapesController {
	private static final SecureRandom random = new SecureRandom();

	@FXML
	private Canvas canvas;

	@FXML
	void drawBullseyePressed(ActionEvent event) {
		GraphicsContext gc = canvas.getGraphicsContext2D();

		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		for (int i = 0; i < 10; i++) {
			gc.setFill(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));

			switch (random.nextInt(2)) {
			case 0:
				gc.fillRect(random.nextInt((int) canvas.getWidth()), random.nextInt((int) canvas.getHeight()),
						random.nextInt((int) canvas.getWidth() / 2), random.nextInt((int) canvas.getHeight() / 2));
				break;
			case 1:
				gc.fillOval(random.nextInt((int) canvas.getWidth()), random.nextInt((int) canvas.getHeight()),
						random.nextInt((int) canvas.getWidth() / 2), random.nextInt((int) canvas.getHeight() / 2));
				break;
			}
		}
	}
}
