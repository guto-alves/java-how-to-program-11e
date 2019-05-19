/*
 * Objetivo: b) Modifique a classe Account na Figura 15.9 para incluir o método combine, que recebe um objeto TransactionRecord e combina
 * o saldo de Account e o valor monetário de TransactionRecord.
 * 
 * Autor: Gustavo Alves
 */

package ch15.ex15_04;

import java.io.Serializable;

public class Account implements Serializable {
	private int account;
	private String firstName;
	private String lastName;
	private double balance;

	public Account() {
		this(0, "", "", 0.0);
	}

	public Account(int account, String firstName, String lastName, double balance) {
		this.account = account;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}

	public void combine(TransactionRecord object) {
		balance += object.getValueForTransaction();
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public int getAccount() {
		return account;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}
}
