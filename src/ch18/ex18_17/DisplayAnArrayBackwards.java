/*
 * Objetivo: 18.17 (Exibir um array de trás para a frente) Escreva um método recursivo
 * stringReverse que aceita um array de caracteres contendo uma string como um argumento
 * e a exibe de trás para a frente. [Dica: utilize o método String toCharArray, que não 
 * aceita nenhum argumento, para obter um array char contendo os caracteres na String.]
 * 
 * Autor: Gustavo Alves
 */

package ch18.ex18_17;

import java.util.Scanner;

public class DisplayAnArrayBackwards {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a word: ");
		String word = scanner.next();
		scanner.close();

		stringReverse(word.toCharArray(), 0);
	}

	public static void stringReverse(char[] array, int index) {
		if (index == array.length - 1) {
			System.out.print(array[index]);
			return;
		} else {
			stringReverse(array, ++index);
			System.out.print(array[index - 1]);
		}
	}
}
