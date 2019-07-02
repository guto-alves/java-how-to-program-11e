/*
 * Objetivo: 16.13 (Eliminação de duplicatas) Escreva um programa que lê em uma série nomes e 
 * elimina duplicatas armazenando-os em um Set. Permita que o usuário procure um primeiro nome.
 * 
 * Autor: Gustavo Alves
 */

package ch16.ex16_13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class EliminacaoDeDuplicatas {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		List<String> list = new ArrayList<String>();

		System.out.printf("%s%n%s%n", "Insira uma série de nomes.",
				"Digite o indicator de fim do arquivo (<Ctrl> z) para finalizar a entrada.");

		while (input.hasNext())
			list.add(input.next());

		input.close();

		eliminarDuplicatas(list);
	}

	public static void eliminarDuplicatas(Collection<String> values) {
		Set<String> set = new HashSet<String>(values);

		System.out.print("Nomes não duplicados: ");

		for (String value : set)
			System.out.printf("%s ", value);
	}
}