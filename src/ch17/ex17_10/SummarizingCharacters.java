/* 17.10 (Summarizing the Characters in a File) Modify the program of
Fig. 17.22 to summarize the number of occurrences of every character in
the file. */

package ch17.ex17_10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SummarizingCharacters {
	public static void main(String[] args) throws IOException {
		Pattern pattern = Pattern.compile("");

		Files.lines(Paths.get("./src/ch17/ex17_10/Chapter2Paragraph.txt"))
			 .flatMap(line -> { 
					line = line.replaceAll("\\W+", "");
					return pattern.splitAsStream(line);})
			 .collect(Collectors.groupingBy(String::toUpperCase, 
						TreeMap::new, Collectors.counting()))
			 .forEach((letter, count) -> {
					System.out.printf("%s: %d%n", letter, count);
			 });
	}
}
