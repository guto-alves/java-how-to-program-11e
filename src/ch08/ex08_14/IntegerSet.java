package ch08.ex08_14;

public class IntegerSet {
	public static final int SET_LENGTH = 101;

	private String name;

	private boolean[] set;

	private int size;

	public IntegerSet() {
		this("", new boolean[SET_LENGTH]);
	}

	public IntegerSet(String name) {
		this(name, new boolean[SET_LENGTH]);
	}

	public IntegerSet(String name, boolean[] set) {
		this.name = name;
		this.set = set;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void insertElement(int element) {
		if (element < 0 || element >= SET_LENGTH)
			throw new IllegalArgumentException("Element is out of range 0-100");

		if (set[element] == false) {
			set[element] = true;
			size++;
		}
	}

	public void deleteElement(int element) {
		if (element < 0 || element >= SET_LENGTH)
			throw new IllegalArgumentException("Element is out of range 0-100");

		if (set[element]) {
			set[element] = false;
			size--;
		}
	}

	public boolean isEqualTo(IntegerSet integerSet) {
		boolean[] anotherSet = integerSet.getSet();

		int equalElementCounter = 0;

		for (int i = 0; i < SET_LENGTH; i++) {
			if (set[i] && anotherSet[i])
				equalElementCounter++;
		}

		return equalElementCounter == size;
	}

	public boolean[] getSet() {
		return set;
	}

	public void setSet(boolean[] set) {
		this.set = set;
	}

	public boolean isEmpty() {
		for (int i = 0; i < SET_LENGTH; i++) {
			if (set[i])
				return false;
		}

		return true;
	}

	public int size() {
		return size;
	}

	public static IntegerSet union(IntegerSet integerSet1, IntegerSet integerSet2) {
		boolean[] unionSet = new boolean[SET_LENGTH];

		boolean[] set1 = integerSet1.getSet();
		boolean[] set2 = integerSet2.getSet();

		for (int i = 0; i < SET_LENGTH; i++) {
			if (set1[i])
				unionSet[i] = true;
			else if (set2[i])
				unionSet[i] = true;
		}

		return new IntegerSet(String.format("%s U %s", integerSet1.getName(), integerSet2.getName()), unionSet);
	}

	public static IntegerSet intersection(IntegerSet integerSet1, IntegerSet integerSet2) {
		boolean[] intersectionSet = new boolean[SET_LENGTH];

		boolean[] set1 = integerSet1.getSet();
		boolean[] set2 = integerSet2.getSet();

		for (int i = 0; i < SET_LENGTH; i++) {
			if (set1[i] && set2[i])
				intersectionSet[i] = true;
		}

		return new IntegerSet(String.format("%s ^ %s", integerSet1.getName(), integerSet2.getName()), intersectionSet);
	}

	public static IntegerSet difference(IntegerSet integerSet1, IntegerSet integerSet2) {
		boolean[] differenceSet = new boolean[SET_LENGTH];

		boolean[] set1 = integerSet1.getSet();
		boolean[] set2 = integerSet2.getSet();

		for (int i = 0; i < SET_LENGTH; i++) {
			if (set1[i] && !set2[i])
				differenceSet[i] = true;
		}

		return new IntegerSet(String.format("%s - %s", integerSet1.getName(), integerSet2.getName()), differenceSet);
	}

	@Override
	public String toString() {
		String string = getName() + " = {";

		for (int i = 0; i < SET_LENGTH; i++) {
			if (set[i])
				string += String.format("%d, ", i);
		}

		try {
			string = string.substring(0, string.lastIndexOf(","));
		} catch (StringIndexOutOfBoundsException e) {
		}

		string += "}";

		return string;
	}

}
