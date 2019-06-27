/*
 * Objetivo: 20.5 (Método genérico sobrecarregado printArray) Sobrecarregue 
 * o método genérico printArray da Figura 20.3 para que ele receba dois 
 * argumentos do tipo inteiro adicionais, lowSubscript e highSubscript. 
 * Uma chamada a esse método imprime somente a parte especificada do array. 
 * Valide lowSubscript e highSubscript. Se um deles estiver fora do 
 * intervalo, o método printArray sobrecarregado deve lançar uma 
 * InvalidSubscriptException; caso contrário, printArray deve retornar o 
 * número de elementos impressos. Então, modifique main para praticar as 
 * duas versões do printArray nos arrays integerArray, doubleArray e 
 * characterArray. Teste todas as capacidades das duas versões de printArray.
 */

package ch20.ex20_05;

public class GenericMethodTest {
	public static void main(String[] args) {
		Integer[] integerArray = { 1, 2, 3, 4, 5, 6 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
		Character[] characterArray = { 'H', 'E', 'L', 'L', 'O' };

		System.out.printf("Array integerArray contains:%n");
		printArray(integerArray);
		System.out.printf("%nArray doubleArray contains:%n");
		printArray(doubleArray);
		System.out.printf("%nArray characterArray contains:%n");
		printArray(characterArray);

		System.out.printf("%n-----------------%n%n");

		System.out.printf("Array integerArray between indices 0-3 contains:%n");
		int total = printArray(integerArray, 0, integerArray.length / 2);
		System.out.printf("--> total of printed elements: %d%n", total);

		System.out.printf("%nArray doubleArray between indices 6-7 contains:%n");
		total = printArray(doubleArray, doubleArray.length - 1, doubleArray.length);
		System.out.printf("--> total of printed elements: %d%n", total);

		System.out.printf("%nArray characterArray between indices 0-1 contains:%n");
		total = printArray(characterArray, 0, 1);
		System.out.printf("--> total of printed elements: %d%n", total);

		printArray(characterArray, -1, 1);
	}

	public static <T> void printArray(T[] inputArray) {
		for (T element : inputArray)
			System.out.printf("%s ", element);

		System.out.println();
	}

	public static <T> int printArray(T[] inputArray, int lowSubscript, int highSubscript) {
		if (lowSubscript < 0 || highSubscript > inputArray.length)
			throw new InvalidSubscriptException();

		int numberOfPrintedElements = 0;

		for (int i = lowSubscript; i < highSubscript; i++) {
			System.out.printf("%s ", inputArray[i]);
			numberOfPrintedElements++;
		}

		return numberOfPrintedElements;
	}
}
