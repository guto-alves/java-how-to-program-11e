package ch24.ex24_04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeQueries {
	private static final String URL = "jdbc:derby:./src/ch24/ex24_04/employees";
	private static final String USERNAME = "deitel";
	private static final String PASSWORD = "deitel";

	private Connection connection;
	private PreparedStatement insertNewEmployee;
	private PreparedStatement insertSalariedEmployee;
	private PreparedStatement insertCommissionEmployee;
	private PreparedStatement insertBasePlusCommissionEmployee;
	private PreparedStatement insertHourlyEmployee;

	public EmployeeQueries() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			insertNewEmployee = connection.prepareStatement(
					"INSERT INTO employees " + 
					"VALUES (?, ?, ?, ?, ?, ?)");

			insertSalariedEmployee = connection.prepareStatement(
					"INSERT INTO salariedEmployees " + 
					"VALUES (?, ?, ?)");

			insertCommissionEmployee = connection.prepareStatement(
					"INSERT INTO commissionEmployees " + 
					"VALUES (?, ?, ?, ?)");
			
			insertBasePlusCommissionEmployee= connection.prepareStatement(
					"INSERT INTO basePlusCommissionEmployees " +
					"VALUES (?, ?, ?, ?, ?)");
			
			insertHourlyEmployee = connection.prepareStatement(
					"INSERT INTO hourlyEmployees " + 
					"VALUES (?, ?, ?, ?)");
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public int addEmployee(String socialSecurityNumber, String firstName, String lastName, String birthday,
			String departmentName, Employee.Type employeeType, String... payrollInfo) {
		try {
			connection.setAutoCommit(false);

			insertNewEmployee.setString(1, socialSecurityNumber);
			insertNewEmployee.setString(2, firstName);
			insertNewEmployee.setString(3, lastName);
			insertNewEmployee.setString(4, birthday);
			insertNewEmployee.setString(5, employeeType.type);
			insertNewEmployee.setString(6, departmentName);
			insertNewEmployee.executeUpdate();

			if (employeeType == Employee.Type.SALARIED) {
				insertSalariedEmployee.setString(1, socialSecurityNumber);
				insertSalariedEmployee.setString(2, payrollInfo[0]);
				insertSalariedEmployee.setString(3, payrollInfo[1]);
				insertSalariedEmployee.executeUpdate();
			} else if (employeeType == Employee.Type.COMISSION) {
				insertCommissionEmployee.setString(1, socialSecurityNumber);
				insertCommissionEmployee.setString(2, payrollInfo[0]);
				insertCommissionEmployee.setString(3, payrollInfo[1]);
				insertCommissionEmployee.setString(4, payrollInfo[2]);
				insertCommissionEmployee.executeUpdate();
			} else if (employeeType == Employee.Type.BASE_PLUS_COMISSION) {
				insertBasePlusCommissionEmployee.setString(1, socialSecurityNumber);
				insertBasePlusCommissionEmployee.setString(2, payrollInfo[0]);
				insertBasePlusCommissionEmployee.setString(3, payrollInfo[1]);
				insertBasePlusCommissionEmployee.setString(4, payrollInfo[2]);
				insertBasePlusCommissionEmployee.setString(5, payrollInfo[3]);
				insertBasePlusCommissionEmployee.executeUpdate();
			} else { // if (employeeType == Employee.Type.HOURLY) {
				insertHourlyEmployee.setString(1, socialSecurityNumber);
				insertHourlyEmployee.setString(2, payrollInfo[0]);
				insertHourlyEmployee.setString(3, payrollInfo[1]);
				insertHourlyEmployee.setString(4, payrollInfo[2]);
				insertHourlyEmployee.executeUpdate();
			}

			connection.commit();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return 0;
	}

}
