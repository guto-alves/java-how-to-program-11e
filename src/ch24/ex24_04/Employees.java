package ch24.ex24_04;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Employees extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		Parent root = 
				FXMLLoader.load(getClass().getResource("Employees.fxml"));
	
		Scene scene = new Scene(root);
		stage.setTitle("Employee Database");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
