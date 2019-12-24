// TipCalculatorController.java
// Controller that handles calculateButton and tipPercentageSlider events

package ch13.ex13_06;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class TipCalculatorController {
	// formatters for currency and percentages
	private static final NumberFormat currency = NumberFormat.getCurrencyInstance();

	private BigDecimal amount;
	private BigDecimal tipPercentage = new BigDecimal(0.15); // 15% default

	// GUI controls defined in FXML and used by the controller's code
	@FXML
	private TextField amountTextField;

	@FXML
	private Label tipPercentageLabel;

	@FXML
	private Slider tipPercentageSlider;

	@FXML
	private TextField tipTextField;

	@FXML
	private TextField totalTextField;

	public void initialize() {
		currency.setRoundingMode(RoundingMode.HALF_UP);

		amountTextField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String oldValue, String newValue) {
				try {
					amount = new BigDecimal(newValue.trim());
				} catch (NumberFormatException e) {
					amount = null;
				}

				calculateTip();
			}
		});

		tipPercentageLabel.textProperty().bind(tipPercentageSlider.valueProperty().asString("%.0f%%"));

		tipPercentageSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
				tipPercentage = BigDecimal.valueOf(newValue.intValue() / 100.0);
				calculateTip();
			}
		});
	}

	private void calculateTip() {
		if (amount != null) {
			BigDecimal tip = amount.multiply(tipPercentage);
			BigDecimal total = amount.add(tip);

			tipTextField.setText(currency.format(tip));
			totalTextField.setText(currency.format(total));
		} else {
			tipTextField.setText(currency.format(0));
			totalTextField.setText(currency.format(0));
		}
	}
}
