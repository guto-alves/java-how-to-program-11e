package ch21.ex21_08;

public class ListTest {
	public static void main(String[] args) {
		SortedList<Integer> list1 = new SortedList<>();
		list1.insert(1);
		list1.insert(2);
		list1.insert(3);
		list1.print();

		SortedList<Integer> list2 = new SortedList<>();
		list2.insert(4);
		list2.insert(5);
		list2.insert(6);

		list1.merge(list2);
		list1.print();
	}
}
