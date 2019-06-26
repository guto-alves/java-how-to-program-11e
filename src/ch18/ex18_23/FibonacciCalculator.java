/*
 * Objetivo: 18.23 (Tempo para calcular números de Fibonacci) Aprimore o programa
 * de Fibonacci da Figura 18.5 para que ele calcule a quantidade aproximada de tempo
 * necessário a fim de efetuar o cálculo e o número de chamadas feitas para o método
 * recursivo. Para esse fim, chame o método static System currentTimeMillis, que não
 * aceita nenhum argumento e retorna a hora atual do computador em milissegundos. 
 * Chame esse método duas vezes, uma antes e outra depois da chamada para fibonacci. 
 * Salve cada valor e calcule a diferença em horas para determinar quantos
 * milissegundos foram necessários ao cálculo. Então, adicione uma variável à classe 
 * FibonacciCalculator e utilize-a para estabelecer o número de chamadas feitas para
 * o método fibonacci. Exiba seus resultados.
 */
package ch18.ex18_23;

import java.math.BigInteger;

public class FibonacciCalculator {
	private static BigInteger TWO = BigInteger.valueOf(2);
	private static long numberOfCalleds = -1;

	public static BigInteger fibonacci(BigInteger number) {
		numberOfCalleds++;
		if (number.equals(BigInteger.ZERO) || number.equals(BigInteger.ONE))
			return number;
		else {
			return fibonacci(number.subtract(BigInteger.ONE)).add(fibonacci(number.subtract(TWO)));
		}
	}

	public static void main(String[] args) {
		for (int counter = 0; counter <= 40; counter++) {
			long timeInitial = System.currentTimeMillis();

			BigInteger result = fibonacci(BigInteger.valueOf(counter));

			long timeFinal = System.currentTimeMillis();

			long diff = timeFinal - timeInitial;

			System.out.printf(
					"Fibonacci of %d is: %-10d --> calculated in %5d milliseconds --> number of calleds: %d%n", counter,
					result, diff, numberOfCalleds);

			numberOfCalleds = -1;
		}
	}
}
