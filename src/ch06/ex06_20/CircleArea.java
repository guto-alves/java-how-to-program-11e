/*
 * Objetivo: 6.20 (Área de círculo) Escreva um aplicativo que solicita ao usuário o raio de um círculo e utiliza
 * um método chamado circleArea para calcular a área do círculo.
 * 
 * Autor: Gustavo Alves
 */

package ch06.ex06_20;

import java.util.Scanner;

public class CircleArea {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter radius of a circle: ");
		double radius = scanner.nextDouble();

		System.out.printf("Circle area is %,.2f cm²", circleArea(radius));
		scanner.close();
	}

	public static double circleArea(double radius) {
		return Math.PI * Math.pow(radius, 2);
	}

}
