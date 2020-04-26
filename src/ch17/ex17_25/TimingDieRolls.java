/* 17.25 (Timing 60,000,000 Die Rolls) In Fig. 17.24 , we implemented a
stream pipeline that rolled a die 60,000,000 times using values produced
by SecureRandom method ints. Package java.time contains types
Instant and Duration that you can use to capture the time before and
after evaluating the stream pipeline, then calculate the difference between
the Instants to determine the total time. Use Instant’s static
method now to get the current time. To determine the difference between
two Instants, use class Duration’s static method between,
which returns a Duration object containing the time difference.
Duration provides methods like toMillis to return a duration in
milliseconds. Use these timing techniques to time the original stream
pipeline’s operation, then do so again using class Random from package
java.util, rather than SecureRandom. */

package ch17.ex17_25;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TimingDieRolls {

	public static void main(String[] args) {
//		Random random = new SecureRandom();
		Random random = new Random();

		System.out.printf("%-6s%s%n", "Face", "Frequency");
		
		Instant initialInstant = Instant.now();
		
		random.ints(60_000, 1, 7)	
		        .boxed()
		        .collect(Collectors.groupingBy(Function.identity(),
		           Collectors.counting()))
		        .forEach((face, frequency) -> 
		           System.out.printf("%-6d%d%n", face, frequency));
			
		Instant finalInstant = Instant.now();
		
		Duration duration = Duration.between(initialInstant, finalInstant);
		System.out.printf("Duration: %d millis", duration.toMillis());
	}

}
