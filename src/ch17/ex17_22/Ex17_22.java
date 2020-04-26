/* 17.22 (Calculating the Average of the Elements in a Two-Dimensional
Array) Figure 7.19 defined a two-dimensional array of grades with 10
rows and three columns, representing 10 students’ grades on three exams.
Use streams to calculate the students’ individual averages. */

package ch17.ex17_22;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex17_22 {

	public static void main(String[] args) {
		 int[][] gradesArray = {{87, 96, 70},      
                 {68, 87, 90},      
                 {94, 100, 90},     
                 {100, 81, 82},     
                 {83, 65, 85},      
                 {78, 87, 65},      
                 {85, 75, 83},      
                 {91, 94, 100},     
                 {76, 72, 84},      
                 {87, 93, 73}};     
		 
		 Stream.of(gradesArray)
		 	.forEach(studentGrades -> {
		 		System.out.printf("%.2f%n",IntStream.of(studentGrades)
		 			.average()
		 			.getAsDouble());
		 	});
	}
}
