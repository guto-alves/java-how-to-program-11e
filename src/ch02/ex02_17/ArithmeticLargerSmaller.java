/*
 * Objetivo: 2.17 (Aritmética, menor e maior) Escreva um aplicativo que insira três
 * inteiros digitados pelo usuário e exiba a soma, média, produto e os números menores
 * e maiores. Utilize as técnicas mostradas na Figura 2.15. [Observação:  o cálculo da
 * média neste exercício deve resultar em uma representação de inteiro. Assim, se a soma
 * dos valores for 7, a média deverá ser 2, não 2,3333...]
 * 
 * Autor: Gustavo Alves
 */

package ch02.ex02_17;

import java.util.Scanner;

public class ArithmeticLargerSmaller {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int number1, number2, number3;

		System.out.print("Enter first integer: ");
		number1 = input.nextInt();

		System.out.print("Enter second integer: ");
		number2 = input.nextInt();

		System.out.print("Enter third integer: ");
		number3 = input.nextInt();
		input.close();

		int sum = number1 + number2 + number3;
		int average = sum / 3;
		int product = number1 * number2 * number3;

		int larger = number1;
		if (number2 > larger)
			larger = number2;
		if (number3 > larger)
			larger = number3;

		int smaller = number1;
		if (number2 < smaller)
			smaller = number2;
		if (number3 < smaller)
			smaller = number3;

		System.out.printf("Sum is %d%n", sum);
		System.out.printf("Media is %d%n", average);
		System.out.printf("Product is %d%n", product);
		System.out.printf("Larger is %d%n", larger);
		System.out.printf("Smaller is %d%n", smaller);
	}
}