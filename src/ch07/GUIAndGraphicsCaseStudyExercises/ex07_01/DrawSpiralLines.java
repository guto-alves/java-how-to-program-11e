package ch07.GUIAndGraphicsCaseStudyExercises.ex07_01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DrawSpiralLines extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader
				.load(getClass().getResource("/ch07/GUIAndGraphicsCaseStudyExercises/ex07_01/DrawSpiralLines.fxml"));

		Scene scene = new Scene(root);
		stage.setTitle("Draw Spiral Lines");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
