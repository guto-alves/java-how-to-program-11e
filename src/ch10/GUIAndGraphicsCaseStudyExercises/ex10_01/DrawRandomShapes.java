package ch10.GUIAndGraphicsCaseStudyExercises.ex10_01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DrawRandomShapes extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("DrawRandomShapes.fxml"));

		Scene scene = new Scene(root); // attach scene graph to scene
		stage.setTitle("Draw Random Shapes"); // displayed in window's title bar
		stage.setScene(scene); // attach scene to stage
		stage.show(); // display the stage
	}

	public static void main(String[] args) {
		launch(args);
	}
}
