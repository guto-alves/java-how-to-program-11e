/*
 * Objetivo: 18.16 (Exibir um array) Escreva um método recursivo printArray que
 * exibe todos os elementos em um array de inteiros, separados por espaços.
 * 
 * Autor: Gustavo Alves
 */

package ch18.ex18_16;

public class PrintArray {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5 };
		printArray(array, array.length);
	}

	public static void printArray(int[] array, int length) {
		if (length == 1) {
			System.out.print(array[0] + " ");
			return;
		} else {
			printArray(array, length - 1);
			System.out.print(array[length - 1] + " ");
		}
	}
}
