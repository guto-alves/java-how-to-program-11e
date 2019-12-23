package ch12.ex12_01;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AdditionAppController {

	@FXML
	private Label resultLabel;

	@FXML
	private TextField number1TextField;

	@FXML
	private TextField number2TextField;

	@FXML
	void calculateSumButtonPressed(ActionEvent event) {
		int number1 = getNumber(number1TextField);
		int number2 = getNumber(number2TextField);
		int sum = number1 + number2;
		resultLabel.setText(String.valueOf(sum));
	}

	private int getNumber(TextField numberTextField) {
		int number = 0;

		try {
			number = Integer.parseInt(numberTextField.getText().trim());
		} catch (NumberFormatException e) {
			numberTextField.setText("Enter an integer");
			numberTextField.selectAll();
			numberTextField.requestFocus();
		}

		return number;
	}

}
