/*
 * Objetivo: 21.6 (Concatenando listas) Escreva um programa que concatena 
 * dois objetos de lista encadeada de caracteres. A classe ListConcatenate 
 * deve incluir um método static concatenate que aceita referências tanto 
 * para objetos de lista como para argumentos e concatena a segunda lista 
 * com a primeira.
 * 
 * Autor: Gustavo Alves
 */

package ch21.ex21_06;

public class ListConcatenate {

	public static List<Character> concatenate(List<Character> list1, List<Character> list2) {
		while (!list2.isEmpty())
			list1.insertAtBack(list2.removeFromFront());

		return list1;
	}

	public static void main(String[] args) {
		List<Character> list1 = new List<>();

		List<Character> list2 = new List<>();

		list1.insertAtBack('a');
		list1.insertAtBack('b');

		list1.insertAtBack('c');
		list1.insertAtBack('d');

		list1 = concatenate(list1, list2);
		list1.print();
	}
}
