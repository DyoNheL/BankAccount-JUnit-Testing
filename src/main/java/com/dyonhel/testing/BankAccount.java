package com.dyonhel.testing;

public class BankAccount {
	private String accountHolder;
	private double balance;

	public BankAccount(String accountHolder, double initialBalance) {
		this.accountHolder = accountHolder;
		if (initialBalance < 0) {
			throw new IllegalArgumentException("Initial balance cannot be negative");
		}
		this.balance = initialBalance;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Deposit amount must be positive");
		}
		balance += amount;
	}

	public void withdraw(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Withdrawal amount must be positive");
		}
		if (amount > balance) {
			throw new IllegalArgumentException("Insufficient funds");
		}
		balance -= amount;
	}

	public boolean transfer(BankAccount toAccount, double amount) {
		if (toAccount == null) {
			throw new IllegalArgumentException("Target account cannot be null");
		}
		if (amount <= 0) {
			throw new IllegalArgumentException("Transfer amount must be positive");
		}
		if (amount > balance) {
			return false;
		}
		this.withdraw(amount);
		toAccount.deposit(amount);
		return true;
	}
}
