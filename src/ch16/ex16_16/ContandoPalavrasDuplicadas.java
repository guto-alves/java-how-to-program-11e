/*
 * Objetivo: 16.16 (Contando palavras duplicadas) Escreva um programa que determina e imprime o número de palavras
 * duplicadas em uma frase. Trate da mesma maneira letras minúsculas e maiúsculas. Ignore a pontuação.
 * 
 * Autor: Gustavo Alves
 */

package ch16.ex16_16;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ContandoPalavrasDuplicadas {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		createMap(map);
		displayMap(map);
	}

	private static void createMap(Map<String, Integer> map) {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite uma string: ");
		String[] tokens = input.nextLine().split(" ");
		input.close();

		for (String token : tokens) {
			String key = token.toUpperCase();

			if (map.containsKey(key))
				map.put(key, map.get(key) + 1);
			else
				map.put(key, 1);
		}

	}

	private static void displayMap(Map<String, Integer> map) {
		Set<String> keys = map.keySet();

		TreeSet<String> sortedKeys = new TreeSet<String>(keys);

		System.out.println("Palavras duplicadas:");
		for (String key : sortedKeys) {
			if (map.get(key) > 1)
				System.out.printf("%s ", key);
		}
	}

}
