/*
 * Objetivo: d) Crie a classe FileMatch para realizar a funcionalidade de correspondência de arquivos. A classe deve conter métodos que leem
 * oldmast.txt e trans.txt. Quando uma correspondência ocorre (isto é, registros com o mesmo número de conta aparecem tanto
 * no arquivo-mestre como no arquivo de transações), adicione o valor monetário no registro de transação ao saldo atual no registro-mestre
 * e grave o registro em "newmast.txt". (Suponha que compras sejam indicadas por montantes positivos no arquivo de transações,
 * e os pagamentos, por valores monetários negativos.) Caso haja um registro-mestre para uma conta particular, mas nenhum registro
 * de transação correspondente, simplesmente grave o registro-mestre em "newmast.txt". Se houver um registro de transação, mas
 * nenhum registro-mestre correspondente, imprima a mensagem "Unmatched transaction record for account number…"
 * [Registro de transação não correspondente para o número da conta] em um arquivo de log (preencha o número
 * da conta a partir do registro de transação). O arquivo de log deve ser um arquivo de texto chamado "log.txt".
 * 
 * Autor: Gustavo Alves
 */

package ch15.ex15_06;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;

import javax.swing.JOptionPane;

public class FileMatch {
	private static ObjectInputStream inputOldMast;
	private static ObjectInputStream inputTrans;
	private static ObjectOutputStream outputNewMast;
	private static Formatter outputLog;

	public static void main(String[] args) {
		matcher();

	}

	private static void matcher() {
		try {
			inputOldMast = new ObjectInputStream(Files.newInputStream(Paths.get("oldmast.ser")));
			outputNewMast = new ObjectOutputStream(Files.newOutputStream(Paths.get("newmast.ser")));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo!", "Error", JOptionPane.ERROR_MESSAGE);
		}

		try {
			while (true) {
				Account account = (Account) inputOldMast.readObject();

				double totalTrans = someTrans(account.getAccount());

				account.setBalance(account.getBalance() + totalTrans);

				outputNewMast.writeObject(account);
			}
		} catch (EOFException e) {

		} catch (ClassNotFoundException e) {

		} catch (IOException e) {

		}

		try {
			inputOldMast.close();
			outputNewMast.close();
		} catch (Exception e) {
		}

		checkTrans();
	}

	private static double someTrans(int accountNumber) {
		try {
			inputTrans = new ObjectInputStream(Files.newInputStream(Paths.get("trans.ser")));
		} catch (IOException e) {
		}

		double totalTrans = 0;

		try {
			while (true) {
				TransactionRecord trRecord = (TransactionRecord) inputTrans.readObject();

				if (trRecord.getAccount() == accountNumber)
					totalTrans += trRecord.getValueForTransaction();

			}

		} catch (EOFException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO: handle exception
		}

		try {
			inputTrans.close();
		} catch (IOException e) {

		}

		return totalTrans;
	}

	public static void checkTrans() {
		try {
			inputTrans = new ObjectInputStream(Files.newInputStream(Paths.get("trans.ser")));
			outputLog = new Formatter("log.txt");
		} catch (Exception e) {
		}

		try {
			while (true) {
				TransactionRecord trRecord = (TransactionRecord) inputTrans.readObject();

				if (runOldMast(trRecord.getAccount())) {
					outputLog.format("%d %s%n", trRecord.getAccount(),
							"Registro de transação não correspondente para o número da conta");
				}

			}
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO: handle exception
		}

		outputLog.close();

		try {
			inputTrans.close();
		} catch (IOException e) {
		}

	}

	public static boolean runOldMast(int accountNumber) {
		try {
			inputOldMast = new ObjectInputStream(Files.newInputStream(Paths.get("oldmast.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			while (true) {
				Account account = (Account) inputOldMast.readObject();

				if (account.getAccount() == accountNumber) {
					inputOldMast.close();
					return false;
				}
			}
		} catch (Exception e) {
		}

		try {
			inputOldMast.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
}
