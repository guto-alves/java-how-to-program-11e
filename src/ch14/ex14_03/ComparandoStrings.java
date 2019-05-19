/*
 * Objetivo: 14.3 (Comparando Strings) Elabore um aplicativo que utiliza o método String compareTo para comparar duas entradas
 * de strings pelo usuário. Crie uma saída informando se a primeira string é menor que, igual a ou maior que a segunda.
 * 
 * Autor: Gustavo Alves
 * Data: 30/03/2019
 */

package ch14.ex14_03;

import java.util.Scanner;

public class ComparandoStrings {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("String 1: ");
		String s1 = scanner.nextLine();

		System.out.print("String 2: ");
		String s2 = scanner.nextLine();
		scanner.close();

		int valueEquals = s1.compareTo(s2);

		if (valueEquals == 0)
			System.out.printf("%s é igual a %s", s1, s2);
		else if (valueEquals > 0)
			System.out.printf("%s é maior que %s", s1, s2);
		else
			System.out.printf("%s é menor que %s", s1, s2);

	}

}
