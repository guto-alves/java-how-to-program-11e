package ch06.GUIAndGraphicsCaseStudyExercises.ex06_01;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DrawBullseye extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader
				.load(getClass().getResource("/ch06/GUIAndGraphicsCaseStudyExercises/ex06_01/DrawBullseye.fxml"));

		Scene scene = new Scene(root);
		stage.setTitle("Bullseye");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
