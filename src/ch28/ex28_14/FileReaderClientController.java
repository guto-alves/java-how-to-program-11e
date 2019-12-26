package ch28.ex28_14;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ch28.ex28_14.Client.MessageReceivedListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FileReaderClientController implements MessageReceivedListener {
	public static Client client;

	private String fileText;

	@FXML
	private TextField fileNameTextField;

	@FXML
	private TextArea contentArea;

	@FXML
	private Button saveChangesButton;

	@FXML
	void saveChangesButtonPressed(ActionEvent event) {
		String changedFileText = contentArea.getText();
		client.sendData(changedFileText);
	}

	@FXML
	void selectFileButtonPressed(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select file");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Text file", "*.txt"));

		File file = fileChooser.showOpenDialog(contentArea.getScene().getWindow());

		if (file != null) {
			fileNameTextField.setText(file.getName());
			client.sendData(file.toPath().toString());
		}
	}

	public void initialize() {
		try {
			client = new Client("127.0.0.1", this);
			ExecutorService executor = Executors.newCachedThreadPool();
			executor.execute(client);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void messageReceived(String message) {
		fileText = message;
		contentArea.setText(fileText);
		contentArea.setDisable(false);
		saveChangesButton.setDisable(false);
	}

}
