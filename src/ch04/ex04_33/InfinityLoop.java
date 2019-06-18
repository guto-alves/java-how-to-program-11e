/*
 * Objetivo: 4.33 (Múltiplos de 2 com um loop infinito) Escreva um aplicativo que continue exibindo na janela de comando
 * os múltiplos do inteiro 2 — a saber, 2, 4, 8, 16, 32, 64 e assim por diante. Seu loop não deve terminar (isto é, deve
 * criar um loop infinito). O que acontece quando você executa esse programa?
 * 
 * Autor: Gustavo Alves
 */

package ch04.ex04_33;

import java.math.BigInteger;

public class InfinityLoop {

	public static void main(String[] args) {
		BigInteger number = new BigInteger("1");

		while (true) {
			number = number.multiply(BigInteger.TWO);
			System.out.println(number);
		}
	}
}
