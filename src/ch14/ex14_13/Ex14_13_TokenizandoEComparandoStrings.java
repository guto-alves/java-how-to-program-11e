/*
 * Objetivo: 14.13 (Tokenizando e comparando Strings) Elabore um aplicativo que lê uma linha de texto, tokeniza essa linha utilizando caracteres de
 * espaço em branco como delimitadores e gera a saída apenas daquelas palavras que iniciam com a letra “b”.
 * 
 * Autor: Gustavo Alves
 * Data: 30/03/2019
 */

package ch14.ex14_13;

import java.util.Scanner;

public class Ex14_13_TokenizandoEComparandoStrings {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Digite uma linha de texto: ");
		String sentence = input.nextLine();
		input.close();

		String[] tokens = sentence.split(" ");

		for (String word : tokens) {
			if (word.substring(0, 1).equals("b"))
				System.out.printf("%s ", word);
		}

	}

}
