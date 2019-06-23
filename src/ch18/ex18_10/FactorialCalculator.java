/*
 * Objetivo: 18.10 (Visualização de recursão) É interessante observar a recursão “em ação”.
 * Modifique o método fatorial na Figura 18.3 para exibir sua variável local e o parâmetro
 * de chamada recursiva. Para cada chamada recursiva, exiba as saídas em uma linha separada
 * e adicione um nível de recuo. Faça o melhor que você puder para tornar a saída limpa,
 * interessante e significativa. Seu objetivo aqui é projetar e implementar um formato de 
 * saída que facilite o entendimento da recursão. Você pode querer adicionar essas capacidades 
 * de exibição a outros exemplos de recursão e a exercícios por todo o texto.
 * 
 * Autor: Gustavo Alves
 */

package ch18.ex18_10;

public class FactorialCalculator {

	public static long factorial(long number) {
		if (number <= 1) {
			System.out.printf("N = %d%n%15s: sei resolver\n%10d! = 1", number, "Caso básico", number);
			return 1;
		} else {
			System.out.printf("N = %d%n", number);
			System.out.printf("%5d! = %d * (%d - 1)!%n%n", number, number, number);
			long result = number * factorial(number - 1);
			System.out.printf("%nN = %d %n%5d * %d = %d%n", number, number, number - 1, result);
			return result;
		}
	}

	public static void main(String[] args) {
		for (int counter = 3; counter <= 3; counter++) // tava 21
			System.out.printf("%n%n%d! = %d%n", counter, factorial(counter));
	}
}
