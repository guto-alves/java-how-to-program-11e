/* 17.17 (Calculating Employee Average Salaries by Department) Modify
the Stream<Employee> example in Section 17.12 so that it uses
stream capabilities to display the average Employee salary by
department. */

package ch17.ex17_17;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProcessingEmployees {

	public static void main(String[] args) {
		List<Employee> list = List.of(
				new Employee("Jason", "Red", 5000, "IT"),
				new Employee("Ashley", "Green", 7600, "IT"), 
				new Employee("Matthew", "Indigo", 3587.5, "Sales"),
				new Employee("James", "Indigo", 4700.77, "Marketing"),
				new Employee("Luke", "Indigo", 6200, "IT"),
				new Employee("Jason", "Blue", 3200, "Sales"), 
				new Employee("Wendy", "Brown", 4236.4, "Marketing"));

		Map<String, List<Employee>> groupedByDepartment = 
				list.stream()
					.collect(Collectors.groupingBy(Employee::getDepartment));

		groupedByDepartment.forEach((department, employees) -> {
			System.out.printf("%s%n", department);
			System.out.printf("Average employee salary: %.2f%n%n", employees.stream()
					.mapToDouble(Employee::getSalary)
					.average()
					.getAsDouble());
		});

	}
}
