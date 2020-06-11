package ch24.ex24_04;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class EmployeesController {
	@FXML
	private TextField socialSecurityNumberTextField;

	@FXML
	private TextField firstNameTextField;

	@FXML
	private TextField lastNameTextField;

	@FXML
	private DatePicker birthdayDatePicker;

	@FXML
	private TextField departmentNameTextField;

	@FXML
	private TabPane payrollTabPane;

	@FXML
	private TextField salariedWeeklySalaryTextField;

	@FXML
	private TextField salariedBonusTextField;

	@FXML
	private TextField commissionGrossSalesTextField;

	@FXML
	private TextField commissionRateTextField;

	@FXML
	private TextField basePlusGrossSalesTextField;

	@FXML
	private TextField basePlusCommissionRateTextField;

	@FXML
	private TextField basePlusSalaryTextField;

	@FXML
	private TextField basePlusBonusTextField;

	@FXML
	private TextField hourlyHoursTextField;

	@FXML
	private TextField hourlyWageTextField;

	@FXML
	private TextField hourlyBonusTextField;

	private final EmployeeQueries employeeQueries = new EmployeeQueries();

	private final Employee.Type[] EMPLOYEES_TYPE = Employee.Type.values();

	public void initialize() {
		birthdayDatePicker.setValue(LocalDate.of(2000, 1, 1));
	}

	@FXML
	void addEmployeeButtonPressed(ActionEvent event) {
		Employee.Type employeeType = EMPLOYEES_TYPE[payrollTabPane.getSelectionModel().getSelectedIndex()];

		String[] payrollInfo;

		if (employeeType == Employee.Type.SALARIED) {
			payrollInfo = new String[] { 
					salariedWeeklySalaryTextField.getText(),
					salariedBonusTextField.getText() };
		} else if (employeeType == Employee.Type.COMISSION) {
			payrollInfo = new String[] {
					commissionGrossSalesTextField.getText(), 
					commissionRateTextField.getText() };
		} else if (employeeType == Employee.Type.BASE_PLUS_COMISSION) {
			payrollInfo = new String[] {
					basePlusGrossSalesTextField.getText(), 
					basePlusCommissionRateTextField.getText(),
					basePlusSalaryTextField.getText(),
					basePlusBonusTextField.getText()};
		} else { // if (employeeType == Employee.Type.HOURLY)
			payrollInfo = new String[] {
					hourlyHoursTextField.getText(),
					hourlyWageTextField.getText(),
					hourlyBonusTextField.getText()};
		}

		int result = employeeQueries.addEmployee(
				socialSecurityNumberTextField.getText(), firstNameTextField.getText(),
				lastNameTextField.getText(), birthdayDatePicker.getValue().toString(), 
				departmentNameTextField.getText(), employeeType, payrollInfo);

		if (result == 1) {
			displayAlert(AlertType.INFORMATION, employeeType.name + " Added", "New entry successfully added.");
		} else {
			displayAlert(AlertType.ERROR, employeeType.name + " Not Added", "Unable to add entry.");
		}
	}
	
	private void displayAlert(AlertType alertType, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.show();
	}

}