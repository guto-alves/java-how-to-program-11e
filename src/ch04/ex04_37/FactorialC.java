/*
 * Objetivo: c) Escreva um aplicativo que computa o valor de e x utilizando a fórmula a seguir. 
 * Permita ao usuário inserir o número de termos a calcular.
 *  e^x = 1 + (x / 1!) + (x² / 2!) + (x³ / 3!) + ...
 * 
 * Autor: Gustavo Alves
 */

package ch04.ex04_37;

import java.util.Scanner;

public class FactorialC {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter expoent: ");
		int expoent = scanner.nextInt();

		System.out.print("Enter number of terms: ");
		int numberOfTerms = scanner.nextInt();
		scanner.close();

		double result = 1;
		int counter = 1;

		while (counter <= numberOfTerms) {
			int auxCounter = counter;
			double factorial = 1;
			while (auxCounter > 0) {
				factorial *= auxCounter;
				auxCounter--;
			}

			result += Math.pow(expoent, counter) / factorial;
			counter++;
		}

		System.out.printf("e^%d = %f", expoent, result);
	}
}
