/*
 * Objetivo: 16.17 (Inserção de elementos de uma LinkedList em uma ordem classificada) Escreva
 * um programa que insere 25 inteiros aleat�rios de 0 a 100 em ordem em um objeto LinkedList.
 * O programa deve classificar os elementos e, ent�o, calcular a soma dos elementos e a
 * média de ponto flutuante deles.
 * 
 * Autor: Gustavo Alves
 */

package ch16.ex16_17;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;

public class InsercaoDeElementosDeUmaLinkedListEmUmaOrdemClassificada {

	public static void main(String[] args) {
		SecureRandom random = new SecureRandom();

		List<Integer> linkedList = new LinkedList<Integer>();

		for (int i = 0; i < 25; i++)
			linkedList.add(random.nextInt(101));

		linkedList.sort(null);

		double average = 0;
		for (int number : linkedList)
			average += number;

		System.out.println(linkedList);
		System.out.printf("Soma: %,.0f%nM�dia: %,.2f", average, average / linkedList.size());
	}
}
