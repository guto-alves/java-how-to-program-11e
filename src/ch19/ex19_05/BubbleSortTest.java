/*
 * Objetivo: 19.5 (Classificação por borbulhamento) Implemente uma
 * classificação por borbulhamento — outra técnica de classificação
 * simples, mas ineficiente. É chamada classificação por borbulhamento
 * ou classificação por afundamento porque os menores valores gradualmente 
 * “borbulham” no seu caminho para a parte superior do array (isto é, na
 * direção do primeiro elemento) como bolhas de ar que emergem na
 * superfície, enquanto os maiores valores afundam na parte inferior (final)
 * do array. A técnica utiliza loops aninhados para fazer várias passagens
 * pelo array. Cada passagem compara pares sucessivos de elementos. Se um
 * par estiver na ordem crescente (ou os valores forem iguais), a
 * classificação por borbulhamento deixa os valores como estão. Se um par
 * estiver na ordem decrescente, a classificação por borbulhamento troca
 * seus valores no array. A primeira passagem compara os dois primeiros
 * elementos do array e troca seus valores, se necessário. Ela então compara
 * o segundo e terceiro elementos no array. O final dessa passagem compara
 * os dois últimos elementos no array e troca-os, se necessário. Depois
 * de uma passagem, o maior elemento estará no último índice. Depois de
 * duas passagens, os dois maiores elementos estarão nos dois últimos
 * índices. Explique por que a classificação por borbulhamento é um
 * algoritmo O(n²).
 * 
 * Autor: Gustavo Alves
 */

package ch19.ex19_05;

import java.security.SecureRandom;
import java.util.Arrays;

public class BubbleSortTest {

	public static void bubbleSort(int[] data) {
		for (int i = 0; i < data.length; i++) {

			for (int j = 0; j < data.length - 1; j++) {
				if (data[j] > data[j + 1])
					swap(data, j, j + 1);
			}
		}
	}

	private static void swap(int[] data, int current, int next) {
		int temporary = data[current];
		data[current] = data[next];
		data[next] = temporary;
	}

	public static void main(String[] args) {
		SecureRandom generator = new SecureRandom();

		int[] data = new int[10];

		for (int i = 0; i < data.length; i++)
			data[i] = 1 + generator.nextInt(100);

		System.out.println(Arrays.toString(data));

		bubbleSort(data);

		System.out.println(Arrays.toString(data));
	}
}
