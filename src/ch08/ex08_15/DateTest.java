package ch08.ex08_15;

public class DateTest {

	public static void main(String[] args) {
		Date date = new Date("March", 27, 2000);

		date.display(Date.MM_DD_YYYY);
		date.display(Date.MONTH_DD_YYYY);
		date.display(Date.DDD_YYYY);
	}
}
