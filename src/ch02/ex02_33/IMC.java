/*
 * Objetivo: 2.33 (Calculadora de índice de massa corporal) Introduzimos a calculadora de índice de massa corporal (IMC) no 
 * Exercício 1.10. As fórmulas para calcular o IMC são 
 * 
 * IMC = (pesoEmLibras × 703) / alturaEmPolegadas²
 * 				  ou
 * IMC = pesoEmQuilogramas / alturaEmMetros²
 * 
 * Crie um aplicativo de calculadora IMC que leia o peso do usuário em libras e a altura em polegadas (ou, se preferir,
 * o peso em quilogramas e a altura em metros) e, então, calcule e exiba o índice de massa corporal dele. Além disso, 
 * que exiba as seguintes informações do Department of Health and Human Services/National Institutes of Health, assim
 * o usuário pode avaliar o seu IMC:
 * 
 * BMI VALUES
 * Underweight:  less than 18.5
 * Normal:		 between 18.5 and 24.9
 * Overweight:   between 25 and 29.9
 * Obese: 		 30 or greater
 * 
 * [Nota: neste capítulo, você aprendeu a utilizar o tipo int para representar números inteiros. Os cálculos de IMC, quando
 * feitos com valores int, produzirão resultados com números inteiros. No Capítulo 3, você aprenderá a utilizar o tipo double
 * para representar números com pontos decimais. Quando os cálculos de IMC são realizados com doubles, eles produzirão números
 * com pontos decimais — esses são chamados de números de “ponto flutuante”.]
 * 
 * Autor: Gustavo Alves
 */

package ch02.ex02_33;

import java.util.Scanner;

public class IMC {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double pesoEmQuilogramas;
		double alturaEmMetros;
		double imc;

		System.out.print("Digite seu peso (em kg): ");
		pesoEmQuilogramas = scanner.nextDouble();

		System.out.print("Digite sua altura(em metros): ");
		alturaEmMetros = scanner.nextDouble();
		scanner.close();

		imc = pesoEmQuilogramas / (alturaEmMetros * alturaEmMetros);

		System.out.printf("%nSeu IMC é %,.2f%n%n", imc);

		System.out.println(
				"Informações do Department of Health and Human Services/National Institutes of Health\n\tBMI VALUES\r\n"
						+ "Abaixo do peso:  menos de 18,5\r\n" + "Normal:          entre 18,5 e 24,9\r\n"
						+ "Excesso de peso: entre 25 e 29,9\r\n" + "Obeso:       	30 ou maior");
	}
}
