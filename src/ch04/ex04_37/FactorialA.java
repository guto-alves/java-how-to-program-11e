/*
 * Objetivo: a) Escreva um aplicativo que lê um inteiro não negativo, calcula e imprime seu fatorial.
 * 
 * Autor: Gustavo Alves
 */

package ch04.ex04_37;

import java.util.Scanner;

public class FactorialA {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a positive integer: ");
		int number = scanner.nextInt();
		scanner.close();

		int aux = number;

		int factorial = 1;
		while (number > 0) {
			factorial *= number;
			number--;
		}

		System.out.printf("%d! = %d", aux, factorial);
	}
}
