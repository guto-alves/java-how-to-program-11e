package ch03.ex03_17;

public class HealthProfileTest {

	public static void main(String[] args) {
		HealthProfile healthProfile = new HealthProfile("Gustavo", "Alves", "Male", 03, 27, 2000, 68.89764, 123.459);

		System.out.printf("First name: %s%n", healthProfile.getFirstName());
		System.out.printf("Last name: %s%n", healthProfile.getLastName());
		System.out.printf("Gender: %s%n", healthProfile.getGender());
		System.out.printf("Date of Birth: %s%n", healthProfile.getDateOfBirth());
		System.out.printf("Height: %.2f%n", healthProfile.getHeight());
		System.out.printf("Weight: %.2f%n", healthProfile.getWeight());
		System.out.printf("BMI: %.2f%n", healthProfile.getBmi());
		System.out.printf("Maximum Heart Rate: %d%n", healthProfile.getMaximumHeartRate());
		System.out.printf("Target Heart Rate: %s%n", healthProfile.getTargetHeartRate());
		System.out.println("\nBMI Categories:\r\n" + "Underweight =< 18.5\r\n" + "Normal weight = 18.5–24.9\r\n"
				+ "Overweight = 25–29.9\r\n" + "Obesity = BMI of 30 or greater");
	}

}
