/*
 * Objetivo: 14.11 (Pesquisando Strings) Elabore um aplicativo que insere uma linha de texto e um caractere de pesquisa e utiliza o 
 * método String indexOf para determinar o número de ocorrências do caractere no texto.
 * 
 * Autor: Gustavo Alves
 * Data: 30/03/2019
 */

package ch14.ex14_11;

import java.util.Scanner;

public class PesquisandoStrings {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Linha de texto: ");
		String string = input.nextLine();

		System.out.print("Caractere pesquisado: ");
		char key = input.next().charAt(0);
		input.close();

		int counter = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.indexOf(key, i) == -1)
				break;
			else {
				counter++;
				i = string.indexOf(key, i);
			}
		}

		System.out.printf("\'%s\' aparece %d vez(es) no texto", key, counter);

	}

}
