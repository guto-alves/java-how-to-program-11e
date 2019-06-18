/*
 * Objetivo: 2.24 (Inteiros maiores e menores) Escreva um aplicativo que leia cinco inteiros, além de determinar
 * e imprimir o maior e o menor inteiro no grupo. Utilize somente as técnicas de programação que você aprendeu 
 * neste capítulo.
 * 
 * Autor: Gustavo Alves
 */

package ch02.ex02_24;

import java.util.Scanner;

public class LargerAndSmallerIntegers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int number1, number2, number3, number4, number5;
		int larger, smaller;

		System.out.print("Enter first integer: ");
		number1 = input.nextInt();

		System.out.print("Enter second integer: ");
		number2 = input.nextInt();

		System.out.print("Enter third integer: ");
		number3 = input.nextInt();

		System.out.print("Enter fourth integer: ");
		number4 = input.nextInt();

		System.out.print("Enter fifth integer: ");
		number5 = input.nextInt();
		input.close();

		larger = number1;
		if (number2 > larger)
			larger = number2;
		if (number3 > larger)
			larger = number3;
		if (number4 > larger)
			larger = number4;
		if (number5 > larger)
			larger = number5;

		smaller = number1;
		if (number2 < smaller)
			smaller = number2;
		if (number3 < smaller)
			smaller = number3;
		if (number3 > smaller)
			smaller = number3;
		if (number4 < smaller)
			smaller = number4;
		if (number5 < smaller)
			smaller = number5;

		System.out.printf("Larger is %d%n", larger);
		System.out.printf("Smaller is %d%n", smaller);
	}
}
