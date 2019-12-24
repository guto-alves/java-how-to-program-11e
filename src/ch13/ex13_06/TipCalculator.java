// Fig. 12.19: TipCalculator.java
// Main application class that loads and displays the Tip Calculator's GUI.

package ch13.ex13_06;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TipCalculator extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/ch13/ex13_06/TipCalculator.fxml"));

		Scene scene = new Scene(root); // attach scene graph to scene
		stage.setTitle("Tip Calculator"); // displayed in window's title bar
		stage.setScene(scene); // attach scene to stage
		stage.show(); // display the stage
	}

	public static void main(String[] args) {
		// create a TipCalculator object and call its start method
		launch(args);
	}
}