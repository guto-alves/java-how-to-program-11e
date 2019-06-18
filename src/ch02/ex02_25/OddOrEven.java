/*
 * Objetivo: 2.25 (Ímpar ou par) Escreva um aplicativo que leia um inteiro, além de determinar e imprimir se ele
 * é ímpar ou par. [Dica: utilize o operador de resto. Um número par é um múltiplo de 2. Qualquer múltiplo de 2
 * deixa um resto 0 quando dividido por 2.]
 * 
 * Autor: Gustavo Alves
 */

package ch02.ex02_25;

import java.util.Scanner;

public class OddOrEven {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a number integer: ");
		int number = scanner.nextInt();
		scanner.close();

		if (number % 2 == 0)
			System.out.printf("%d is even", number);
		if (number % 2 != 0)
			System.out.printf("%d is odd", number);
	}
}