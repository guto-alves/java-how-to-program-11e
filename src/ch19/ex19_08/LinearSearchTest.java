/*
 * Objetivo: 19.8 (Pesquisa linear recursiva) Modifique a Figura 19.2 para 
 * usar o método recursivo recursiveLinearSearch para realizar uma pesquisa
 * linear do array. O método deve receber a chave de pesquisa e o índice 
 * inicial como argumentos. Se a chave de pesquisa for encontrada, seu 
 * índice no array é retornado; caso contrário, –1 é retornado. Cada 
 * chamada ao método recursivo deve verificar um índice no array.
 */

package ch19.ex19_08;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class LinearSearchTest {

	public static int recursiveLinearSearch(int data[], int searchKey, int initialIndex) {
		if (initialIndex >= data.length)
			return -1;
		if (data[initialIndex] == searchKey)
			return initialIndex;

		return recursiveLinearSearch(data, searchKey, initialIndex + 1);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		SecureRandom generator = new SecureRandom();

		int[] data = new int[10];

		for (int i = 0; i < data.length; i++)
			data[i] = 10 + generator.nextInt(90);

		System.out.printf("%s%n%n", Arrays.toString(data));

		System.out.print("Please enter an integer value (-1 to quit): ");
		int searchInt = input.nextInt();

		while (searchInt != -1) {
			int position = recursiveLinearSearch(data, searchInt, 0);

			if (position == -1)
				System.out.printf("%d was not found%n%n", searchInt);
			else
				System.out.printf("%d was found in position %d%n%n", searchInt, position);

			System.out.print("Please enter an integer value (-1 to quit): ");
			searchInt = input.nextInt();
		}

		input.close();
	}
}
