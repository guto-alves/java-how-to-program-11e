/*
 * Objetivo: 14.19 (Imprimindo datas em vários formatos) As datas são impressas em vários formatos comuns. Dois dos formatos mais comuns em 
 * inglês são 04/25/1955 e April 25, 1955. Elabore um aplicativo que lê uma data no primeiro formato e imprime no segundo formato.
 * 
 * Autor: Gustavo Alves
 * Data: 14/04/2019
 */

package ch14.ex14_19;

import java.util.Scanner;

public class ImprimindoDatasVariosFormatos {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite uma data no formato 04/25/1999: ");
		String data = scanner.nextLine();
		scanner.close();

		System.out.println(converteFormato(data));

	}

	public static String converteFormato(String data) {
		String[] mesesEmIngles = { "", "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };

		String[] tokens = data.split("/");

		return String.format("%s %s, %s", mesesEmIngles[Integer.parseInt(tokens[0])], tokens[1], tokens[2]);
	}

}
