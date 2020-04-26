/* 17.18 (Summing the Triples of the Even Integers from 2 through 10)
The example of Fig. 17.7 summed the triples of the even integers from 2
through 10. We used filter and map in the stream pipeline to
demonstrate both in one stream pipeline. Reimplement Fig. 17.7 ’s stream
pipeline using only map (similar to Fig. 17.4 ). */

package ch17.ex17_18;

import java.util.stream.IntStream;

public class SummingTheTriplesOfTheEven {

	public static void main(String[] args) {
		System.out.printf(
		         "Sum of the triples of the even ints from 2 through 10 is: %d%n",
		         IntStream.rangeClosed(1, 5)
		                  .map(x -> x * 2 * 3)
		                  .sum()); 
	}
}
