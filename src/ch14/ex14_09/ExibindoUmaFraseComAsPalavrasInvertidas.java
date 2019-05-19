/*
 * Objetivo: 14.9 (Exibindo uma frase com as palavras invertidas) Elabore um aplicativo que insere uma linha de texto, tokeniza a linha 
 * com o método String split e gera os tokens na ordem inversa. Utilize caracteres de espaço em branco como delimitadores.
 * 
 * Autor: Gustavo Alves
 * Data: 30/03/2019
 */

package ch14.ex14_09;

import java.util.Scanner;

public class ExibindoUmaFraseComAsPalavrasInvertidas {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Digite uma frase: ");
		String sentence = input.nextLine();
		input.close();

		String[] tokens = sentence.split(" ");
		for (int i = tokens.length - 1; i >= 0; i--)
			System.out.print(tokens[i] + " ");
	}

}
