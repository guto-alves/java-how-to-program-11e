package ch21.ex21_07;

import java.security.SecureRandom;

public class ListTest {
	public static void main(String[] args) {
		SecureRandom generator = new SecureRandom();

		SortedList<Integer> list = new SortedList<>();

		for (int i = 0; i < 25; i++)
			list.insert(generator.nextInt(101));

		list.print();
	}
}
