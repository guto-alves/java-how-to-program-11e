package ch05.GUIAndGraphicsCaseStudyExercises.ex05_01;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DrawCircles extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader
				.load(getClass().getResource("/ch05/GUIAndGraphicsCaseStudyExercises/ex05_01/DrawCircles.fxml"));

		Scene scene = new Scene(root);
		stage.setTitle("Concentric Circles");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
