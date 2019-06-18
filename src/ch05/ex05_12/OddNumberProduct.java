/*
 * Objetivo: 5.12 (Calculando o produto de números inteiros ímpares) Escreva um aplicativo que calcula o produto dos 
 * números inteiros ímpares de 1 a 15.
 * 
 * Autor: Gustavo Alves
 */

package ch05.ex05_12;

public class OddNumberProduct {

	public static void main(String[] args) {
		int product = 1;

		for (int i = 1; i <= 15; i += 2)
			product *= i;

		System.out.println(product);
	}
}
