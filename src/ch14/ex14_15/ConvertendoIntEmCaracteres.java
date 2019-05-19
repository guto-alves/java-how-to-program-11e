/*
 * Objetivo: 14.15 (Convertendo valores int em caracteres) Elabore um aplicativo que insere um código de inteiros para um caractere e exibe 
 * o caractere correspondente. Modifique esse aplicativo de modo que ele gere todos os possíveis códigos de três dígitos no intervalo de 000 
 * a 255 e tente imprimir os caracteres correspondentes.
 * 
 * Autor: Gustavo Alves
 * Data: 13/04/2019
 */

package ch14.ex14_15;

public class ConvertendoIntEmCaracteres {

	public static void main(String[] args) {
		for (int i = 0; i <= 255; i++)
			System.out.printf("%d = %c%n", i, i);

	}

}
