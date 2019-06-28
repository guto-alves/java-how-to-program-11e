/*
 * Objetivo: 8.4 (Classe Rectangle) Crie uma classe Rectangle com os 
 * atributos length e width, cada um dos quais assume o padrão de 1. 
 * Forneça os métodos que calculam o perímetro e a área do retângulo. 
 * A classe tem métodos set e get para o comprimento (length) e a 
 * largura (width). Os métodos set devem verificar se length e width 
 * são, cada um, números de ponto flutuante maiores que 0,0 e menores
 * que 20,0. Escreva um programa para testar a classe Rectangle.
 * 
 * Autor: Gustavo Alves
 */

package ch08.ex08_04;

public class RectangleTest {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(7, 3);

		System.out.println(rectangle);
		System.out.printf("Rectangle area = %,.1f%n", rectangle.area());
		System.out.printf("Rectangle perimiter = %,.1f ", rectangle.perimiter());
	}
}
