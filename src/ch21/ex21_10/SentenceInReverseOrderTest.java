/*
 * Objetivo: 21.10 (Imprimindo uma frase na ordem inversa usando um pilha) 
 * Escreva um programa que insere uma linha de texto e usa uma pilha para 
 * exibir as palavras da linha na ordem inversa.
 */

package ch21.ex21_10;

import java.util.Scanner;

public class SentenceInReverseOrderTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		StackComposition<String> stack = new StackComposition<>();

		System.out.print("Enter a line of text: ");
		String text = input.nextLine();
		input.close();

		String[] tokens = text.replaceAll("(?!')\\p{P}", "").split(" ");

		for (String string : tokens)
			stack.push(string);

		stack.print();
	}
}
