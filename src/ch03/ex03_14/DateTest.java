package ch03.ex03_14;

public class DateTest {

	public static void main(String[] args) {
		Date date = new Date(3, 27, 2000);

		date.displayDate();

		date.setMonth(12);
		date.setDay(16);
		date.setYear(2019);

		date.displayDate();
	}
}
