/*
 * Objetivo: 18.18 (Localizar o valor mínimo em um array) Escreva um método
 * recursivo recursiveMinimum que determina o menor elemento em um array de
 * inteiros. O método deve retornar quando ele receber um array de um elemento.
 * 
 * Autor: Gustavo Alves
 */

package ch18.ex18_18;

public class Ex18_18 {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 15, 2, 0 };
		System.out.println(recursiveMinimum(array, array.length));
	}

	public static int recursiveMinimum(int[] array, int length) {
		if (length == 1)
			return array[0];
		else {
			int x = recursiveMinimum(array, length - 1);

			if (x < array[length - 1])
				return x;
			else
				return array[length - 1];
		}
	}
}
