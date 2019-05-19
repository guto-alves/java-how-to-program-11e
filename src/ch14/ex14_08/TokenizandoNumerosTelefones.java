/*
 * Objetivo: 14.8 (Tokenizando números de telefone) Elabore um aplicativo que insere um número de telefone como uma string na forma (555)
 * 555-5555. O aplicativo deve utilizar o método String split para extrair o código de área como um token, os três primeiros dígitos do
 * número de telefone como um segundo token e os últimos quatro dígitos do número de telefone como um terceiro token. Os sete dígitos do
 * número de telefone devem ser concatenados em uma string. O código de área e o número de telefone devem ser impressos. Lembre-se de
 * que você que terá de alterar caracteres delimitadores durante o processo de tokenização.
 * 
 * Autor: Gustavo Alves
 * Data: 30/03/2019
 */

package ch14.ex14_08;

import java.util.Scanner;

public class TokenizandoNumerosTelefones {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Digite um número de telefone na forma (555) 555-5555: ");
		String number = input.nextLine();
		input.close();

		String[] tokens = number.split("[()\\s\\-]");

		for (int i = 0; i < tokens.length; i++)
			System.out.print(tokens[i]);

	}

}
