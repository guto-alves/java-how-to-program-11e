/*
 * Objetivo: 5.20 (Calculando o valor de π) Calcule o valor de π a partir de uma série infinita
 * 
 * 			π = 4 - (4/3) + (4/5) - (4/7) + (4/9) - (4/11) + ...
 *  
 * Imprima uma tabela que mostre o valor aproximado de π calculando os 200.000 primeiros termos dessa série. 
 * Quantos termos você tem de utilizar antes de primeiro obter um valor que começa com 3,14159?
 * 
 * Autor: Gustavo Alves
 */

package ch05.ex05_20;

public class ValueOfPI {

	public static void main(String[] args) {
		double pi = 0;
		double numberOdd = 1;
		for (int i = 0; i < 200000; i++) {
			if (i % 2 == 0)
				pi += 4 / numberOdd;
			else
				pi -= 4 / numberOdd;

			numberOdd += 2;
		}

		System.out.printf("π = %f", pi);
	}

}
