/*
 * Objetivo: 2.32 (Valores negativos, positivos e zero) Escreva um programa que insira cinco números,
 * além de determinar e imprimir quantos negativos, quantos positivos e quantos zeros foram inseridos.
 * 
 * Autor: Gustavo Alves
 */

package ch02.ex02_32;

import java.util.Scanner;

public class ValoresPositivosNegativosEZero {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int number1, number2, number3, number4, number5;

		System.out.print("Digite o primeiro inteiro: ");
		number1 = input.nextInt();

		System.out.print("Digite o segundo inteiro: ");
		number2 = input.nextInt();

		System.out.print("Digite o terceiro inteiro: ");
		number3 = input.nextInt();

		System.out.print("Digite o quarto inteiro: ");
		number4 = input.nextInt();

		System.out.print("Digite o quinto inteiro: ");
		number5 = input.nextInt();
		input.close();

		int negativos = 0, positivos = 0, zeros = 0;

		if (number1 == 0)
			zeros++;
		if (number2 == 0)
			zeros++;
		if (number3 == 0)
			zeros++;
		if (number4 == 0)
			zeros++;
		if (number5 == 0)
			zeros++;

		if (number1 < 0)
			negativos++;
		if (number2 < 0)
			negativos++;
		if (number3 < 0)
			negativos++;
		if (number4 < 0)
			negativos++;
		if (number5 < 0)
			negativos++;

		if (number1 > 0)
			positivos++;
		if (number2 > 0)
			positivos++;
		if (number3 > 0)
			positivos++;
		if (number4 > 0)
			positivos++;
		if (number5 > 0)
			positivos++;

		System.out.println("Quantidade de positivos: " + positivos);
		System.out.println("Quantidade de negativos: " + negativos);
		System.out.println("Quantidade de zeros: " + zeros);
	}
}