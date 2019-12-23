/* 10.14 (Project: Shape Hierarchy) Implement the Shape hierarchy
shown in Fig. 9.3 . Each TwoDimensionalShape should contain
method getArea to calculate the area of the two-dimensional shape.
Each ThreeDimensionalShape should have methods getArea and
getVolume to calculate the surface area and volume, respectively, of the
three-dimensional shape. Create a program that uses an array of Shape
references to objects of each concrete class in the hierarchy. The program
should print a text description of the object to which each array element
refers. Also, in the loop that processes all the shapes in the array,
determine whether each shape is a TwoDimensionalShape or a
ThreeDimensionalShape. If it’s a TwoDimensionalShape,
display its area. If it’s a ThreeDimensionalShape, display its area
and volume. */

package ch10.ex10_14;

public class Test {

	public static void main(String[] args) {
		Shape[] shapes = new Shape[6];
		shapes[0] = new Circle(3);
		shapes[1] = new Square(2);
		shapes[2] = new Triangle(2, 5);
		shapes[3] = new Sphere(3);
		shapes[4] = new Cube(5);
		shapes[5] = new Tetrahedron(3);

		for (Shape shape : shapes) {
			System.out.println(shape);

			if (shape instanceof TwoDimensionalShape) {
				TwoDimensionalShape twoDimensionalShape = (TwoDimensionalShape) shape;
				System.out.printf("area = %.2f%n%n", twoDimensionalShape.getArea());
			} else {
				ThreeDimensionalShape threeDimensionalShape = (ThreeDimensionalShape) shape;
				System.out.printf("area = %.2f%n", threeDimensionalShape.getArea());
				System.out.printf("volume = %.2f%n%n", threeDimensionalShape.getVolume());
			}
		}
	}

}
