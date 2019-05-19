/*
 * Objetivo: c) Escreva um programa para criar dados a fim de testar o programa. Utilize os dados de exemplo da conta nas figuras 
 * 15.14 e 15.15. Execute o programa para criar os arquivos trans.txt e oldmast.txt a serem utilizados por seu programa de correspondência
 * de arquivos.
 * 
 * Autor: Gustavo Alves
 */

package ch15.ex15_06;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

public class CreateData {
	private static ObjectOutputStream outputOldMast;
	private static ObjectOutputStream outputTrans;

	public static void main(String[] args) {
		menuOption();
	}

	public static void menuOption() {
		int option;
		do {
			option = Integer
					.parseInt(JOptionPane.showInputDialog(null,
							String.format("Insira a opção%n%s%n%s%n%s", "1 - Registrar no arquivo-mestre",
									"2 - Registrar transações", "9 - Sair"),
							"Menu de Opções", JOptionPane.QUESTION_MESSAGE));

			switch (option) {
			case 1:
				openFileOldMast();
				addRegisterOldMast();
				closeFileOldMast();
				break;
			case 2:
				openFileTrans();
				addRegisterTrans();
				closeFileTrans();
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Encerrando ...");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}

		} while (option != 9);
	}

	public static void openFileOldMast() {
		try {
			outputOldMast = new ObjectOutputStream(Files.newOutputStream(Paths.get("oldmast.ser")));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo!", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void addRegisterOldMast() {
		while (true) {
			int addOrNot = JOptionPane.showConfirmDialog(null, "Acicionar registro?", "Registrar no arquivo-mestre",
					JOptionPane.YES_NO_OPTION);

			if (addOrNot == 0) {

				try {
					Account account = new Account(Integer.parseInt(JOptionPane.showInputDialog("Número de conta: ")),
							JOptionPane.showInputDialog("Primeiro nome:"), JOptionPane.showInputDialog("Último nome:"),
							Double.parseDouble(JOptionPane.showInputDialog("Saldo:")));

					outputOldMast.writeObject(account);

				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Entrada inválida!", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Erro ao gravar no arquivo!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			} else if (addOrNot == 1)
				return;
			else
				JOptionPane.showMessageDialog(null, "Opção inválida!", "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	public static void closeFileOldMast() {
		try {
			if (outputOldMast != null)
				outputOldMast.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao fechar o arquivo!", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	private static void openFileTrans() {
		try {
			outputTrans = new ObjectOutputStream(Files.newOutputStream(Paths.get("trans.ser")));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private static void addRegisterTrans() {
		while (true) {
			int addOrNot = JOptionPane.showConfirmDialog(null, "Acicionar transação?", "Registrar Transação",
					JOptionPane.YES_NO_OPTION);

			if (addOrNot == 0) {
				try {
					TransactionRecord transactionRecord = new TransactionRecord(
							Integer.parseInt(JOptionPane.showInputDialog("Número de conta:")),
							Double.parseDouble(JOptionPane.showInputDialog("Quantia da transação:")));

					outputTrans.writeObject(transactionRecord);

				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Entrada inválida. Tente novamente!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Erro ao gravar no arquivo!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			} else if (addOrNot == 1)
				return;
			else
				JOptionPane.showMessageDialog(null, "Opção inválida!", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	private static void closeFileTrans() {
		try {
			if (outputTrans != null)
				outputTrans.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao fechar o arquivo!", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

}
