package ch12.ex12_04;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.NumberFormat;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class MortgageCalculatorController {
	private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
	private static final NumberFormat percent = NumberFormat.getPercentInstance();

	private BigDecimal monthlyPayment;
	private BigInteger years = new BigInteger("10");
	private BigDecimal rate = new BigDecimal(".01");

	@FXML
	private TextField purchasePriceTextField;

	@FXML
	private TextField downPaymentTextField;

	@FXML
	private TextField monthlyPaymentTextField;

	@FXML
	private Label loanDurationLabel;

	@FXML
	private Slider loanDurationSlider;

	@FXML
	private Label interestRateLabel;

	@FXML
	private Slider interestRateSlider;

	@FXML
	void calculateMortgageButtonPressed(ActionEvent event) {
		BigDecimal purchasePrice = new BigDecimal(purchasePriceTextField.getText().trim());
		BigDecimal downPayment = new BigDecimal(downPaymentTextField.getText().trim());
		BigDecimal total = purchasePrice.subtract(downPayment);

		BigInteger totalMonthys = years.multiply(new BigInteger("12"));

		monthlyPayment = total.multiply(rate).add(total).divide(new BigDecimal(totalMonthys), RoundingMode.UP);

		monthlyPaymentTextField.setText(currency.format(monthlyPayment));
	}

	public void initialize() {
		interestRateSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue) {
				rate = BigDecimal.valueOf(newValue.intValue() / 100.0);
				interestRateLabel.setText(String.format("Interest rate (%s)", percent.format(rate)));
			}
		});

		loanDurationSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue) {
				years = BigInteger.valueOf(newValue.intValue());
				loanDurationLabel.setText(String.format("Loan duration (%s %s)", years,
						years.compareTo(BigInteger.ONE) > 0 ? "years" : "year"));
			}
		});

	}
}
