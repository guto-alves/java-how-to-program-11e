package ch21.ex21_09;

public class ReverseCopy {

	public static <T> List<T> reverseCopy(List<T> list) {
		List<T> reverseList = new List<>();

		for (int i = 0; i < list.size(); i++)
			reverseList.insertAtFront(list.get(i));

		return reverseList;
	}

	public static void main(String[] args) {
		List<String> list = new List<>();

		list.insertAtBack("green");
		list.insertAtBack("yellow");
		list.insertAtBack("blue");
		list.print();

		List<String> reverseList = reverseCopy(list);
		reverseList.print();
	}
}
