/*
 * Objetivo: 19.5 19.6 (Classificação por borbulhamento aprimorada) Faça 
 * as seguintes modificações simples para melhorar o desempenho da 
 * classificação por borbulhamento que você desenvolveu na Questão 19.5:
 * 
 * a) Depois da primeira passagem, garante-se que o número maior está no
 * elemento de número mais alto do array; após a segunda passagem, os
 * dois números mais altos estão “no lugar”; e assim por diante. Em vez
 * de fazer nove comparações em cada passagem para um array de 10
 * elementos, modifique a classificação por borbulhamento para fazer
 * oito comparações na segunda passagem, sete na terceira passagem e
 * assim por diante. 
 * 
 * 
 * b) Os dados no array já podem estar na ordem adequada ou quase
 * adequada, então por que fazer nove passagens se menos seriam
 * suficientes? Modifique a classificação para verificar  no fim
 * de cada passagem se alguma troca foi feita. Se não houvesse 
 * nenhum, os dados já deveriam estar classificados, assim o programa 
 * deve terminar. Se trocas foram feitas, pelo menos mais uma passagem 
 * é necessária.
 * 
 * Autor: Gustavo Alves
 */

package ch19.ex19_06;

import java.security.SecureRandom;
import java.util.Arrays;

public class BubbleSortTest {

	public static void bubbleSortA(int[] data) {
		for (int i = data.length - 1; i > 0; i--) {

			for (int j = 0; j < i; j++) {
				if (data[j] > data[j + 1])
					swap(data, j, j + 1);
			}
		}
	}

	public static void bubbleSortB(int[] data) {
		boolean swapped = true;

		while (swapped) {
			swapped = false;

			for (int j = 0; j < data.length - 1; j++) {
				if (data[j] > data[j + 1]) {
					swap(data, j, j + 1);
					swapped = true;
				}
			}
		}
	}

	private static void swap(int[] data, int first, int second) {
		int temporary = data[first];
		data[first] = data[second];
		data[second] = temporary;
	}

	public static void main(String[] args) {
		SecureRandom generator = new SecureRandom();

		int[] data = new int[10];

		for (int i = 0; i < data.length; i++)
			data[i] = 1 + generator.nextInt(100);

		System.out.println(Arrays.toString(data));

		// bubbleSortA(data);
		bubbleSortB(data);

		System.out.println(Arrays.toString(data));
	}
}
