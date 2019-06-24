/*
 * Objetivo: 7.14 (Lista de argumento de comprimento variável) Escreva um aplicativo que
 * calcula o produto de uma série de inteiros que são passados para método product 
 * utilizando uma lista de argumentos de comprimento variável. Teste seu método com várias 
 * chamadas, cada uma com um número diferente de argumentos.
 * 
 * Autor: Gustavo Alves
 */

package ch07.ex07_14;

public class ListaDeArgumentoDeComprimentoVariavel {

	public static int product(int... numbers) {
		int total = 1;

		for (int i : numbers)
			total *= i;

		return total;
	}

	public static void main(String[] args) {
		System.out.println(product(10, 10));
		System.out.println(product(10, 10, 10));
		System.out.println(product(10, 10, 10, 10));
	}
}
