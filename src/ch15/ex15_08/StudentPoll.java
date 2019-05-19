// Fig. 7.8: StudentPoll.java
// Poll analysis program.

package ch15.ex15_08;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class StudentPoll {
	private static Scanner inputReader;
	private static Formatter outputWriter;
	private static int[] frequency = new int[6];

	public static void main(String[] args) {
		checkFrequency();
		writeFrequency();
	}

	public static void checkFrequency() {
		try {
			inputReader = new Scanner(Paths.get("numbers.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (inputReader.hasNext()) {
			try {
				++frequency[inputReader.nextInt()];
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e);
			}
		}

		inputReader.close();
	}

	public static void writeFrequency() {
		try {
			outputWriter = new Formatter("output.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		outputWriter.format("%s%10s%n", "Rating", "Frequency");

		for (int i = 1; i < frequency.length; i++)
			outputWriter.format("%6d%10d%n", i, frequency[i]);

		outputWriter.close();
	}

}
