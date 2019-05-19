/*
 * Objetivo: 14.20 (Proteção de cheque) Os computadores frequentemente empregaram em sistemas de verificação de escrita como aplicativos 
 * de folha de pagamento e contas a pagar. Ouvimos muitas histórias estranhas relacionadas a cheques de pagamento semanal que são impressos 
 * (por engano) com quantias de mais de US$ 1 milhão. Quantidades incorretas são impressas por sistemas computadorizados de preenchimento
 * de cheque por causa de erro humano ou falha de máquina. Os projetistas de sistemas embutem controles em seus sistemas para evitar a
 * emissão desses cheques errados.
 * 		Outro problema sério é a alteração intencional do valor de um cheque por alguém que planeja receber um cheque de modo fraudulento.
 * Para evitar que uma quantia monetária seja alterada, alguns sistemas computadorizados de preenchimento de cheque empregam uma
 * técnica chamada proteção de cheque. Cheques projetados para imprimir por computador contêm um número fixo de espaços em que o
 * computador pode imprimir uma quantia. Suponha que um cheque de pagamento contenha oito espaços em branco em que o computador
 * deve imprimir a quantidade de um cheque de pagamento semanal. Se o valor for alto, então todos os oito espaços serão preenchidos. Por
 * exemplo,
 * 
 * 1,230.60 (valor do cheque)
 * --------
 * 12345678 (números de posição)
 * 
 * Por outro lado, se a quantidade for menor que US$ 1000, então vários dos espaços seriam comumente deixados em branco. Por exemplo,
 * 
 *    99.87
 * --------
 * 12345678
 * 
 * contém três espaços em branco. Se um cheque é impresso com espaços em branco, é mais fácil que alguém altere o valor. Para evitar a alteração,
 * muitos sistemas de escrita de cheque inserem asteriscos à esquerda para proteger o valor como a seguir:
 * 
 * ***99.87
 * --------
 * 12345678
 * 
 * Elabore um aplicativo que insere uma quantia monetária que será impressa em um cheque e então imprime o valor em formato de cheque
 * protegido com asteriscos iniciais, se necessário. Suponha que nove espaços estão disponíveis para imprimir o valor.
 * 
 * Autor: Gustavo Alves
 * Data: 14/04/2019
 */

package ch14.ex14_20;

import java.util.Scanner;

public class ProtecaoDeCheque {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Digite uma quntia montária que será impressa em um cheque (Ex. 1,230.60): ");
		String quantia = input.nextLine();
		input.close();

		System.out.println("Quantia protegida: " + protecaoDeCheque(quantia));

	}

	public static String protecaoDeCheque(String quantia) {
		if (quantia.length() == 8)
			return quantia;
		else {
			int espacosEmBranco = 8 - quantia.length();

			StringBuilder quantiaProtegida = new StringBuilder();

			for (int i = 0; i < espacosEmBranco; i++)
				quantiaProtegida.append("*");

			quantiaProtegida.append(quantia);

			return String.valueOf(quantiaProtegida);
		}

	}

}
