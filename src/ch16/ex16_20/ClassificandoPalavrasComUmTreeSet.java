/*
 * Objetivo: 16.20 (Classificando palavras com um TreeSet) Escreva um programa que utiliza um método String split para tokenizar uma linha
 * de entrada de texto fornecida pelo usuário e coloca cada token em um TreeSet. Imprima os elementos do TreeSet. [Observação: isso
 * deve fazer com que os elementos sejam impressos na ordem de classificação ascendente.]
 * 
 * Autor: Gustavo Alves
 */

package ch16.ex16_20;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ClassificandoPalavrasComUmTreeSet {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite um linha de texto: ");
		String[] tokens = scanner.nextLine().split(" ");
		scanner.close();

		Set<String> set = new TreeSet<String>(Arrays.asList(tokens));

		for (String word : set)
			System.out.printf("%s ", word);

	}

}
