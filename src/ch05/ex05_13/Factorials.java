/*
 * Objetivo: 5.13 (Fatoriais) Fatoriais costumam ser utilizados em problemas de probabilidade. O fatorial de um inteiro positivo
 * n (escrito como n! e pronunciado como “fatorial de n”) é igual ao produto dos números inteiros positivos de 1 a n. Escreva um
 * aplicativo que calcula os fatoriais de 1 a 20. Utilize o tipo long. Exiba os resultados em formato tabular. Que dificuldade
 * poderia impedir você de calcular o fatorial de 100?
 * 
 * Autor: Gustavo Alves
 */

package ch05.ex05_13;

public class Factorials {

	public static void main(String[] args) {
		for (int i = 0; i <= 20; i++) {
			
			long factorial = 1;
			for (int j = 2; j <= i; j++)
				factorial *= j;

			System.out.printf("%d! = %d%n", i, factorial);
		}
	}
}
