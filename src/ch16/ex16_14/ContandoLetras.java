/*
 * Objetivo: 16.14 (Contando letras) Modifique o programa da Figura 16.18 para contar o número de 
 * ocorrências de cada letra em vez do número de cada palavra. Por exemplo, a string "HELLO THERE" 
 * contém dois Hs, três Es, dois Ls, um O, um T e um R. Exiba os resultados.
 * 
 * Autor: Gustavo Alves
 */

package ch16.ex16_14;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ContandoLetras {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();

		createMap(map);
		displayMap(map);

		System.out.println(map);
	}

	private static void createMap(Map<String, Integer> map) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String text = scanner.nextLine();
		scanner.close();

		for (int i = 0; i < text.length(); i++) {
			String key = String.format("%s", text.charAt(i)).toUpperCase();

			if (key.equals(" "))
				continue;
			if (map.containsKey(key))
				map.put(key, map.get(key) + 1);
			else
				map.put(key, 1);
		}

	}

	private static void displayMap(Map<String, Integer> map) {
		Set<String> keys = map.keySet();

		TreeSet<String> sortedKeys = new TreeSet<>(keys);

		System.out.printf("%2s%10s%n", "Letra", "Vezes");

		for (String key : sortedKeys)
			System.out.printf("%2s %10s%n", key, map.get(key));
	}

}
