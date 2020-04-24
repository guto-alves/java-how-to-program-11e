package ch03.ex03_17;

import java.util.Calendar;

public class HealthProfile {
	private String firstName;
	private String lastName;
	private String gender;
	private int month;
	private int day;
	private int year;
	private double height; // in inches
	private double weight; // in pounds

	public HealthProfile(String firstName, String lastName, String gender, int month, int day, int year, double height,
			double weight) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.month = month;
		this.day = day;
		this.year = year;
		this.height = height;
		this.weight = weight;
	}

	public int getAge() {
		return Calendar.getInstance().get(Calendar.YEAR) - year;
	}

	public int getMaximumHeartRate() {
		return 220 - getAge();
	}

	public String getTargetHeartRate() {
		return String.format("%.0f-%.0f", getMaximumHeartRate() * 0.5, getMaximumHeartRate() * 0.85);
	}

	public double getBmi() {
		return (double) (weight * 703) / (height * height);
	}

	public String getDateOfBirth() {
		return String.format("%d/%d/%d", month, day, year);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
