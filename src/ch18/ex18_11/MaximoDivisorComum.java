/*
 * Objetivo: 18.11 (Máximo divisor comum) O máximo divisor comum dos inteiros x e y é o maior
 * inteiro que divide tanto x como y. Escreva um método recursivo gcd que retorna o máximo divisor
 * comum de x e y. O gcd de x e y é definido recursivamente como segue: se y é igual a 0, então
 * gcd(x, y) é x; do contrário, gcd(x, y) é gcd(y, x % y), onde % é o operador de resto. Utilize
 * esse método para substituir o que você escreveu no aplicativo do Exercício 6.27.
 * 
 * Autor: Gustavo Alves
 */

package ch18.ex18_11;

import java.util.Scanner;

public class MaximoDivisorComum {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Digite o valor de x: ");
		int x = input.nextInt();

		System.out.print("Digite o valor de y: ");
		int y = input.nextInt();
		input.close();

		System.out.printf("MDC(%d, %d) = %d", x, y, gcd(x, y));
	}

	public static int gcd(int x, int y) {
		if (y == 0)
			return x;
		else
			return gcd(y, x % y);
	}
}
