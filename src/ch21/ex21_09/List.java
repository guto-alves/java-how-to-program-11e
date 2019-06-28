
package ch21.ex21_09;

class ListNode<T> {

	T data;
	ListNode<T> nextNode;

	ListNode(T object) {
		this(object, null);
	}

	ListNode(T object, ListNode<T> node) {
		data = object;
		nextNode = node;
	}

	T getData() {
		return data;
	}

	ListNode<T> getNext() {
		return nextNode;
	}
}

public class List<T> {
	private ListNode<T> firstNode;
	private ListNode<T> lastNode;
	private String name;
	private int size = 0;

	public List() {
		this("list");
	}

	public List(String listName) {
		name = listName;
		firstNode = lastNode = null;
		size = 0;
	}

	public void insertAtFront(T insertItem) {
		if (isEmpty())
			firstNode = lastNode = new ListNode<T>(insertItem);
		else
			firstNode = new ListNode<T>(insertItem, firstNode);

		size++;
	}

	public void insertAtBack(T insertItem) {
		if (isEmpty())
			firstNode = lastNode = new ListNode<T>(insertItem);
		else
			lastNode = lastNode.nextNode = new ListNode<T>(insertItem);

		size++;
	}

	public T removeFromFront() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException(name);

		T removedItem = firstNode.data;

		if (firstNode == lastNode)
			firstNode = lastNode = null;
		else
			firstNode = firstNode.nextNode;

		size--;
		return removedItem;
	}

	public T removeFromBack() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException(name);

		T removedItem = lastNode.data;

		if (firstNode == lastNode)
			firstNode = lastNode = null;
		else {
			ListNode<T> current = firstNode;

			while (current.nextNode != lastNode)
				current = current.nextNode;

			lastNode = current;
			current.nextNode = null;
		}

		size--;
		return removedItem;
	}

	public boolean isEmpty() {
		return firstNode == null;
	}

	public int size() {
		return size;
	}

	public T get(int index) {
		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException();

		ListNode<T> current = firstNode;

		int counter = 0;

		while (current != null) {
			if (counter == index)
				return current.data;

			counter++;
			current = current.nextNode;
		}

		return null;
	}

	public void print() {
		if (isEmpty()) {
			System.out.printf("Empty %s%n", name);
			return;
		}

		System.out.printf("The %s is: ", name);
		ListNode<T> current = firstNode;

		while (current != null) {
			System.out.printf("%s ", current.data);
			current = current.nextNode;
		}

		System.out.println();
	}
}
