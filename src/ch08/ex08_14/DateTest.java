package ch08.ex08_14;

public class DateTest {

	public static void main(String[] args) {
		Date date = new Date(86, 2000);

		date.display(Date.MM_DD_YYYY);
		date.display(Date.Month_DD_YYYY);
		date.display(Date.DDD_YYYY);
	}
}
