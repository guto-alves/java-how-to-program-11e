/*
 * Objetivo: 19.9 (Pesquisa binária recursiva) Modifique a Figura 19.3 para 
 * usar o método recursivo recursiveBinarySearch a fim de realizar uma 
 * pesquisa binária do array. O método deve receber a chave de pesquisa, o 
 * índice inicial e o índice final como argumentos. Se a chave de pesquisa 
 * for encontrada, seu índice no array é retornado. Se a chave de pesquisa 
 * não for encontrada, é retornado –1.
 */

package ch19.ex19_09;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTest {

	public static int recursiveBinarySearch(int[] data, int key, int low, int high) {
		if (low > high)
			return -1;

		int middle = (low + high + 1) / 2;

		if (key == data[middle])
			return middle;
		else if (key < data[middle])
			return recursiveBinarySearch(data, key, low, middle - 1);
		else
			return recursiveBinarySearch(data, key, middle + 1, high);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		SecureRandom generator = new SecureRandom();

		int[] data = new int[15];

		for (int i = 0; i < data.length; i++)
			data[i] = 10 + generator.nextInt(90);

		Arrays.sort(data);
		System.out.printf("%s%n%n", Arrays.toString(data));

		System.out.print("Please enter an integer value (-1 to quit): ");
		int searchInt = input.nextInt();

		while (searchInt != -1) {
			int location = recursiveBinarySearch(data, searchInt, 0, data.length - 1);

			if (location == -1)
				System.out.printf("%d was not found%n%n", searchInt);
			else
				System.out.printf("%d was found in position %d%n%n", searchInt, location);

			System.out.print("Please enter an integer value (-1 to quit): ");
			searchInt = input.nextInt();
		}

		input.close();
	}
}
