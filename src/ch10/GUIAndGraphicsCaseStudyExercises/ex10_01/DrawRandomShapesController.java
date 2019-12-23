package ch10.GUIAndGraphicsCaseStudyExercises.ex10_01;

import java.security.SecureRandom;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class DrawRandomShapesController {
	private static final SecureRandom random = new SecureRandom();

	@FXML
	private TextField numberOfShapesTextField;

	@FXML
	private Canvas canvas;

	private ArrayList<MyShape> shapes = new ArrayList<MyShape>();

	@FXML
	void drawShapesButtonPressed(ActionEvent event) {
		GraphicsContext gc = canvas.getGraphicsContext2D();

		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		generateShapes();

		drawShapes(gc);
	}

	private void generateShapes() {
		shapes.clear();
		int width = (int) canvas.getWidth();
		int height = (int) canvas.getHeight();

		int shapesQuantity = Integer.parseInt(numberOfShapesTextField.getText());

		for (int i = 0; i < shapesQuantity; i++) {
			int x1 = random.nextInt(width);
			int y1 = random.nextInt(height);
			int x2 = random.nextInt(width);
			int y2 = random.nextInt(height);

			Color strokeColor = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));

			int shapeNumber = random.nextInt(3);

			switch (shapeNumber) {
			case 0:
				shapes.add(new MyLine(x1, y1, x2, y2, strokeColor));
				break;
			case 1:
				Color fillColor = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
				shapes.add(new MyRectangle(x1, y1, x2, y2, strokeColor, random.nextInt(2) == 1, fillColor));
				break;
			case 2:
				fillColor = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
				shapes.add(new MyOval(x1, y1, x2, y2, strokeColor, random.nextInt(2) == 1, fillColor));
				break;
			}
		}
	}

	private void drawShapes(GraphicsContext gc) {
		for (MyShape shape : shapes)
			shape.draw(gc);
	}
}