/*
 * Objetivo: 18.9 (Método recursivo power) Escreva uma método recursivo power(base, exponent) 
 * que, quando chamado, retorna 
 * 
 * 			base^exponente
 * 
 * Por exemplo, power(3,4) = 3 * 3 * 3 * 3. Assuma que exponent é um inteiro maior ou igual a 1.
 * Dica: o passo de recursão deve adotar o relacionamento
 * 
 *			base ^ exponente = base * base^(exponente – 1)
 * 
 * e a condição de terminação se manifesta quando exponent é igual a 1 porque
 * 
			base¹ = base
			
 * Incorpore esse método em um programa que permita que o usuário insira a base e o exponent.
 * 
 * Autor: Gustavo Alves
 */

package ch18.ex18_09;

import javax.swing.JOptionPane;

public class RecursivoPower {

	public static void main(String[] args) {
		int base = Integer.parseInt(JOptionPane.showInputDialog("Digite a base: "));
		int exponent = Integer.parseInt(JOptionPane.showInputDialog("Digite o expoente: "));

		JOptionPane.showMessageDialog(null, String.format("%d ^ %d = %d", base, exponent, power(base, exponent)));
	}

	public static int power(int base, int exponent) {
		if (exponent == 1)
			return base;
		else
			return base * power(base, exponent - 1);
	}
}
