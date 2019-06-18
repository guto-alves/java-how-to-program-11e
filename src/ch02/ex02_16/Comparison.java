/*
 * Objetivo: 2.16 (Comparando inteiros) Escreva um aplicativo que solicite ao usuário inserir dois inteiros, obtenha dele esses
 * números e exiba o número maior seguido pelas palavras “is larger". Se os números forem iguais, imprima a mensagem “These numbers
 * are equal". Utilize as técnicas mostradas na Figura 2.15.
 * 
 * Autor: Gustavo Alves
 */

package ch02.ex02_16;

import java.util.Scanner;

public class Comparison {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter first number: ");
		int number1 = scanner.nextInt();

		System.out.print("Enter second number: ");
		int number2 = scanner.nextInt();
		scanner.close();

		if (number1 == number2)
			System.out.println("These numbers are equal");

		if (number1 > number2)
			System.out.printf("%d is larger", number1);

		if (number1 < number2)
			System.out.printf("%d is larger", number2);
	}
}
