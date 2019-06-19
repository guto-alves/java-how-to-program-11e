package ch17.ex17_09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamOfLines {
	public static void main(String[] args) throws IOException {
		Pattern pattern = Pattern.compile("");

		Map<String, Long> letterCounts = Files.lines(Paths.get("./src/ch17/ex17_09/Chapter2Paragraph.txt"))
				.map(line -> line.replaceAll("\\p{P}", ""))
				.flatMap(line -> pattern.splitAsStream(line))
				.collect(Collectors.groupingBy(String::toUpperCase, TreeMap::new, Collectors.counting()));

		letterCounts.entrySet().stream()
				.collect(Collectors.groupingBy(entry -> entry.getKey().charAt(0), TreeMap::new, Collectors.toList()))
				.forEach((letter, wordList) -> {
					wordList.stream().forEach(word -> System.out.printf("%s: %d%n", word.getKey(), word.getValue()));
				});
	}
}
