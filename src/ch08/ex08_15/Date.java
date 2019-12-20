/* 8.15 (Date Class) Create class Date with the following capabilities:
 
1. Output the date in multiple formats, such as
  
  	MM/DD/YYYY 
  	June 14, 1992 
  	DDD YYYY
  
2. Use overloaded constructors to create Date objects initialized
with dates of the formats in part (a). In the first case the
constructor should receive three integer values. In the second
case it should receive a String and two integer values. In the
third case it should receive two integer values, the first of which
represents the day number in the year. */

package ch08.ex08_15;

public class Date {
	public final static int MM_DD_YYYY = 1;
	public final static int MONTH_DD_YYYY = 2;
	public final static int DDD_YYYY = 3;

	private final int[] daysPerMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final String[] months = { "", "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };

	private int day;
	private int year;
	private int month;
	private int numberOfDaysPerYear;

	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
		numberOfDaysPerYear = calculateNumberOfDaysPerYear();
	}

	public Date(String month, int day, int year) {
		for (int i = 1; i < months.length; i++) {
			if (months[i].equals(month))
				this.month = i;
		}

		this.day = day;
		this.year = year;
		numberOfDaysPerYear = calculateNumberOfDaysPerYear();
	}

	public Date(int numberOfDaysPerYear, int year) {
		this.numberOfDaysPerYear = numberOfDaysPerYear;
		this.year = year;
		month = 1;

		for (int i = 1; i < daysPerMonth.length; i++) {
			if (numberOfDaysPerYear - daysPerMonth[i] > 0) {
				numberOfDaysPerYear -= daysPerMonth[i];
				month++;
			} else
				break;
		}

		day = numberOfDaysPerYear;
	}

	public void display(int format) {
		switch (format) {
		case MM_DD_YYYY:
			System.out.printf("%02d/%02d/%d%n", month, day, year);
			break;
		case MONTH_DD_YYYY:
			System.out.printf("%s %02d, %d%n", months[month], day, year);
			break;
		case DDD_YYYY:
			System.out.printf("%03d %d%n", numberOfDaysPerYear, year);
			break;
		default:
			break;
		}
	}

	private int calculateNumberOfDaysPerYear() {
		int numberOfDaysPerYear = day;

		for (int i = 1; i < daysPerMonth.length; i++) {
			if (i < month)
				numberOfDaysPerYear += daysPerMonth[i];
			else
				break;
		}
		return numberOfDaysPerYear;
	}
}
