/*
 * Objetivo: 20.7 (Método genérico isEqualTo) Escreva uma versão genérica 
 * simples do método isEqualTo que compara seus dois argumentos com o 
 * método equals e retorna true se forem iguais e false caso contrário. 
 * Utilize esse método genérico em um programa que chama isEqualTo com uma 
 * variedade de tipos predefinidos, como Object ou Integer. Qual resultado 
 * você obtém ao tentar executar esse programa?
 * 
 * Autor: Gustavo Alves
 */

package ch20.ex20_07;

public class GenericMethodIsEqualToTest {

	public static <T> boolean isEqualTo(T arg1, T arg2) {
		return arg1.equals(arg2);
	}

	public static void main(String[] args) {
		System.out.println(isEqualTo(1, "1"));
		System.out.println(isEqualTo(1, 1));
		System.out.println(isEqualTo(1.0, 1));
		System.out.println(isEqualTo('a', 'a'));
	}
}
