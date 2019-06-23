/*
 * Objetivo: 18.14 (Palíndromos) Um palíndromo é uma string que pode ser lida igualmente
 * da esquerda para a direita e da direita para a esquerda. Alguns exemplos de palíndromos
 * são “radar”, “a cara rajada da jararaca” e “a bola da loba”. Escreva um método recursivo
 * testPalindrome que retorna o valor boolean true, se a string armazenada no array for um
 * palíndromo, e false, caso contrário. O método deve ignorar espaços e pontuação na string.
 * 
 * Autor: Gustavo Alves
 */

package ch18.ex18_14;

import java.util.Scanner;

public class Palindromos {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter a line of text: ");
		String string = removePunctuation(input.nextLine());
		input.close();

		System.out.printf("It %s a palindrome!", testPalindrome(string, 0, string.length() - 1) ? "is" : "is not");
	}

	public static boolean testPalindrome(String phrase, int min, int max) {
		if (phrase.charAt(min) != phrase.charAt(max))
			return false;
		else if (min >= max)
			return true;

		testPalindrome(phrase, min + 1, max - 1);

		return true;
	}

	public static String removePunctuation(String phrase) {
		return phrase.replaceAll("\\p{P}", "").replaceAll("\\s+", "");
	}
}
