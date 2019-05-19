/*
 * Objetivo: 14.4 (Comparando partes de Strings) Elabore um aplicativo que utiliza o método String regionMatches para comparar duas
 * entradas de strings pelo usuário. O aplicativo deve inserir o número de caracteres que será comparado e o índice inicial da comparação.
 * O aplicativo deve declarar se as strings são iguais. Ignore a distinção entre maiúsculas e minúsculas dos caracteres ao realizar a 
 * comparação.
 * 
 * Autor: Gustavo Alves
 * Data: 30/03/2019
 */

package ch14.ex14_04;

import java.util.Scanner;

public class ComparandoPartesDeStrings {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("String 1: ");
		String s1 = input.nextLine();

		System.out.print("String 2: ");
		String s2 = input.nextLine();
		input.close();

		System.out.printf("As string %s iguais.", s1.regionMatches(true, 0, s2, 0, 2) ? "são" : "não são");

	}

}
