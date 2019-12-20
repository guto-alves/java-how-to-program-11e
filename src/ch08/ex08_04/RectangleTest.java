/* 8.4 (Rectangle Class) Create a class Rectangle with attributes length
and width, each of which defaults to 1. Provide methods that calculate
the rectangle’s perimeter and area. It has set and get methods for both
length and width. The set methods should verify that length and
width are each floating-point numbers larger than 0.0 and less than 20.0.
Write a program to test class Rectangle. */

package ch08.ex08_04;

public class RectangleTest {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(2, 2);

		System.out.println(rectangle);
		System.out.printf("Rectangle area = %,.1f%n", rectangle.area());
		System.out.printf("Rectangle perimiter = %,.1f ", rectangle.perimiter());
	}
}
