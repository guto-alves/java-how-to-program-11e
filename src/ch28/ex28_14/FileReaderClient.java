package ch28.ex28_14;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FileReaderClient extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/ch28/ex28_14/FileReaderClient.fxml"));

		Scene scene = new Scene(root);
		stage.setTitle("File Reader");
		stage.setScene(scene);
		stage.show();
		stage.setOnCloseRequest(e -> {
			FileReaderClientController.client.closeConnection();
			System.exit(0);
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
