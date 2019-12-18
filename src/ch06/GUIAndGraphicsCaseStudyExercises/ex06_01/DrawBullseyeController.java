package ch06.GUIAndGraphicsCaseStudyExercises.ex06_01;

import java.security.SecureRandom;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawBullseyeController {
	private static final SecureRandom random = new SecureRandom();

	@FXML
	private Canvas canvas;

	@FXML
	void drawBullseyePressed(ActionEvent event) {
		GraphicsContext gc = canvas.getGraphicsContext2D();

		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		Color color1 = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
		Color color2 = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));

		for (int i = 0; i < 5; i++) {
			gc.setFill(i % 2 == 0 ? color1 : color2);

			gc.fillOval(20 + 25 * i, 20 + 25 * i, 250 - 50 * i, 250 - 50 * i);
		}

	}

}
