/*
 * Objetivo: 14.12 (Pesquisando Strings) Elabore um aplicativo baseado no aplicativo da Questão 14.11 que insere uma linha de texto e utiliza o 
 * método String indexOf para determinar o número total de ocorrências de cada letra do alfabeto no texto. As letras minúsculas e maiúsculas
 * devem ser contadas juntas. Armazene os totais para cada letra em um array e imprima os valores em formato tabular depois que os totais
 * foram determinados.
 * 
 * Autor: Gustavo Alves
 * Data: 13/04/2019
 */

package ch14.ex14_12;

import java.util.Scanner;

public class PesquisandoStrings {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite uma linha de texto: ");
		String text = scanner.nextLine();
		scanner.close();

		int[] frequencia = determinarFrequenciaLetra(text);

		exibirFrequencia(frequencia);
	}

	public static int[] determinarFrequenciaLetra(String text) {
		final int TOTAL_LETRAS_ALFABETO = 26;
		int[] frequenciaLetras = new int[26];

		text = text.toUpperCase();

		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < TOTAL_LETRAS_ALFABETO; j++) {
				if ('A' + j == text.charAt(i))
					frequenciaLetras[j]++;
			}
		}

		return frequenciaLetras;
	}

	public static void exibirFrequencia(int[] frequenciaLetras) {
		System.out.printf("%s %10s%n", "Letra", "Frequência");

		for (int i = 0; i < frequenciaLetras.length; i++)
			System.out.printf("%3c %9d%n", 'A' + i, frequenciaLetras[i]);

	}

}
