/*
 * Objetivo: 19.7 (Bucket sort) Uma classificação do tipo bucket sort inicia
 * com um array unidimensional de inteiros positivos a ser classificado e 
 * um array bidimensional de inteiros com linhas indexadas de 0 a 9 e colunas 
 * indexadas de 0 a n – 1, onde n é o número dos valores a ser classificado. 
 * Cada linha do array bidimensional é chamada bucket. Escreva uma classe 
 * chamada BucketSort que contém um método chamado sort que opera desta 
 * maneira: 
 * 
 * a) Coloque cada valor do array unidimensional em uma linha do array de
 * bucket, com base nas “unidades” (mais à direita) do dígito. Por exemplo, 
 * 97 é colocado na linha 7, 3 é colocado na linha 3 e 100 é colocado na linha 
 * 0. Esse procedimento é chamado de passagem de distribuição. 
 * 
 * b) Realize um loop pelo array de bucket linha por linha e copie os valores
 * de volta para o array original. Esse procedimento é chamado passagem de 
 * coleta. A nova ordem dos valores precedentes no array unidimensional é 100,
 * 3 e 97. 
 * 
 * c) Repita esse processo para a posição de cada dígito subsequente (dezenas,
 * centenas, milhares etc.). Na segunda passagem (dígitos das dezenas), 100 é 
 * colocado na linha 0, 3 é colocado na linha 0 (porque 3 não tem nenhum 
 * dígito de dezena) e 97 é colocado na linha 9. Depois da passagem de coleta,
 * a ordem dos valores no array unidimensional é 100, 3 e 97. Na terceira
 * passagem (dígitos das centenas), 100 é colocado na linha 1, 3 é colocado
 * na linha 0 e 97 é colocado na linha 0 (depois do 3). Depois dessa última 
 * passagem de coleta, o array original está na ordem classificada. 
 * 
 * O array bidimensional dos buckets tem 10 vezes o comprimento do array
 * de inteiros sendo classificado. Essa técnica de classificação fornece 
 * um melhor desempenho do que uma classificação por borbulhamento, mas exige 
 * muito mais memória — a classificação por borbulhamento exige espaço para 
 * somente um elemento adicional de dados. Essa comparação é um exemplo 
 * da relação de troca espaço/tempo: a bucket sort utiliza mais memória que a 
 * classificação por borbulhamento, mas seu desempenho é melhor. Essa versão 
 * da bucket sort requer cópia de todos os dados de volta para o array 
 * original a cada passagem. Outra possibilidade é criar um segundo array 
 * de bucket bidimensional e permutar os dados repetidamente entre os dois 
 * arrays de bucket.
 * 
 * Autor: Gustavo Alves
 */

package ch19.ex19_07;

import java.util.Arrays;

public class BucketSort {

	public static void bucketSort(int[] data) {
		int[][] bucket = new int[10][data.length];
		int[] columnCounter = new int[bucket.length];
		int i, j;
		int digits = 1;

		do {
			for (i = 0; i < bucket.length; i++) {
				for (j = 0; j < bucket[0].length; j++)
					bucket[i][j] = -1;
			}

			for (i = 0; i < columnCounter.length; i++)
				columnCounter[i] = 0;

			// passagem de distribuição
			for (i = 0; i < data.length; i++) {
				int row = (data[i] / digits) % 10;

				bucket[row][columnCounter[row]] = data[i];
				columnCounter[row]++;
			}

			// passagem de coleta
			int counter = 0;
			for (i = 0; i < bucket.length; i++) {
				for (j = 0; j < bucket[0].length; j++) {
					if (bucket[i][j] != -1) {
						data[counter] = bucket[i][j];
						counter++;
						bucket[i][j] = -1;
					}
				}
			}

			digits *= 10;
		} while (columnCounter[0] < data.length);
	}

	public static void main(String[] args) {
		int[] data = { 97, 3, 100, 1 };

		System.out.println(Arrays.toString(data));

		bucketSort(data);

		System.out.println(Arrays.toString(data));
	}
}
