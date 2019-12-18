package ch06.GUIAndGraphicsCaseStudyExercises.ex06_02;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DrawShapes extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader
				.load(getClass().getResource("/ch06/GUIAndGraphicsCaseStudyExercises/ex06_02/DrawShapes.fxml"));

		Scene scene = new Scene(root);
		stage.setTitle("Random Shapes");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
