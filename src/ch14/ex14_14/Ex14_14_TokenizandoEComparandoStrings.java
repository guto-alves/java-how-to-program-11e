/*
 * Objetivo: 14.14 (Tokenizando e comparando Strings) Elabore um aplicativo que lê uma linha de texto, tokeniza essa linha utilizando 
 * caracteres de espaço em branco como delimitadores e gera a saída apenas daquelas palavras que terminem com as letras “ED”.
 * 
 * Autor: Gustavo Alves
 * Data: 13/04/2019
 */

package ch14.ex14_14;

import java.util.Scanner;

public class Ex14_14_TokenizandoEComparandoStrings {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite uma linha de texto: ");
		String text = scanner.nextLine();
		scanner.close();

		String[] tokens = text.split(" ");

		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].lastIndexOf("ED") != -1)
				System.out.println(tokens[i]);
		}

	}

}
