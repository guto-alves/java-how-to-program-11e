package ch08.ex08_14;

public class IntegerSetTest {

	public static void main(String[] args) {
		IntegerSet integerSet1 = new IntegerSet("A");
		IntegerSet integerSet2 = new IntegerSet("B");

		integerSet1.insertElement(1);
		integerSet1.insertElement(2);
		integerSet1.insertElement(3);

		integerSet2.insertElement(3);
		integerSet2.insertElement(4);
		integerSet2.insertElement(5);
		integerSet2.insertElement(6);

		System.out.printf("Sets: %n%s%n%s%n%n", integerSet1, integerSet2);

		System.out.println("Operations: ");
		System.out.println(IntegerSet.union(integerSet1, integerSet2));
		System.out.println(IntegerSet.intersection(integerSet1, integerSet2));
		System.out.println(IntegerSet.difference(integerSet1, integerSet2));

		System.out.printf("%nA %s equal to B%n", integerSet1.isEqualTo(integerSet2) ? "is" : "is not");
	}

}
