/*
 * Objetivo: 6.18 (Exibindo um quadrado de asteriscos) Escreva um método squareOfAsterisks
 * que exibe um quadrado sólido (o mesmo número de linhas e colunas) de asteriscos cujo lado
 * é especificado no parâmetro inteiro side. Por exemplo, se side for 4, o método deverá exibir
 * 
 *   ****
 *   ****
 *	 ****
 *	 ****
 * Incorpore esse método a um aplicativo que lê um valor inteiro para side a partir da entrada
 * fornecida pelo usuário e gera saída dos asteriscos com o método squareOfAsterisks.
 * 
 * Autor: Gustavo Alves
 */

package ch06.ex06_18;

import java.util.Scanner;

public class SquareOfAsterisks {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the side of square: ");
		squareOfAsterisks(scanner.nextInt());

		scanner.close();
	}

	public static void squareOfAsterisks(int side) {
		String result = "";

		for (int i = 0; i < side; i++) {
			for (int j = 0; j < side; j++)
				result += "*";

			result += "\n";
		}

		System.out.println(result);
	}
}
