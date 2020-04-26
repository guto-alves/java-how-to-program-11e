/* 17.21 (Calculating the Average of the Elements in a Two-Dimensional
Array) Figure 7.19 defined a two-dimensional array of grades with 10
rows and three columns, representing 10 students’ grades on three exams.
Use a stream pipeline to calculate the average of all the grades. For this
exercise, use Stream method of to create a stream from the two-dimensional
array and Stream method flatMapToInt to map each
row into a stream of int values. */

package ch17.ex17_21;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex17_21 {

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
		 
		 System.out.println(Stream.of(gradesArray)
		 	.flatMapToInt(row -> IntStream.of(row))
		 	.average()
		 	.getAsDouble());
	}
}
