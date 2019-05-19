/*
 * Objetivo: 15.8 (Pesquisa entre alunos) A Figura 7.8 contém um array de respostas a uma pesquisa que é codificado diretamente no programa. 
 * Suponha que queremos processar os resultados dessa pesquisa que são armazenados em um arquivo. Este exercício requer dois programas separados.
 * Primeiro, crie um aplicativo que solicita ao usuário respostas à pesquisa e gera a saída de cada resposta para um arquivo. Utilize um
 * Formatter para criar um arquivo chamado numbers.txt. Cada inteiro deve ser escrito com o método format. Então modifique o programa que 
 * aparece na Figura 7.8 para ler as respostas à pesquisa a partir de numbers.txt. As respostas devem ser lidas do arquivo utilizando um 
 * Scanner. Use o método nextInt para inserir um número inteiro de cada vez a partir do arquivo. O programa precisa continuar a ler respostas
 * até alcançar o fim desse arquivo. A saída dos resultados deve ser gerada no arquivo de texto "output.txt".
 * 
 * Autor: Gustavo Alves
 */

package ch15.ex15_08;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class PesquisaEntreAlunos {
	private static Formatter output;

	public static void main(String[] args) {
		int[] responses = gatherResponses();

		openFile();
		addRecords(responses);
		closeFile();
	}

	public static int[] gatherResponses() {
		Scanner scanner = new Scanner(System.in);

		final int AMOUNT = 5;
		int[] responses = new int[AMOUNT];

		for (int i = 0; i < responses.length; i++) {
			System.out.printf("%dª rating: ", i + 1);
			responses[i] = scanner.nextInt();
		}
		scanner.close();
		return responses;
	}

	public static void openFile() {
		try {
			output = new Formatter("numbers.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void addRecords(int[] responses) {
		for (int i = 0; i < responses.length; i++)
			output.format("%d%n", responses[i]);

	}

	public static void closeFile() {
		if (output != null)
			output.close();
	}

}
