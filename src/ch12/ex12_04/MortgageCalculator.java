package ch12.ex12_04;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MortgageCalculator extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/ch12/ex12_04/MortgageCalculator.fxml"));

		Scene scene = new Scene(root);
		stage.setTitle("Mortgage Calculator");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
