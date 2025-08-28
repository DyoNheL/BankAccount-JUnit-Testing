package com.dyonhel.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

	private BankAccount account;

	@BeforeEach
	void setUp() {
		account = new BankAccount("Juan", 100.0);
	}

	@Test
	void testInitialBalance() {
		assertEquals(100.0, account.getBalance(), 0.001);
		assertEquals("Juan", account.getAccountHolder());
	}

	@Test
	void testDeposit() {
		account.deposit(50.0);
		assertEquals(150.0, account.getBalance(), 0.001);
	}

	@Test
	void testDepositNegativeAmount() {
		try {
			account.deposit(-10.0);
			fail("Expected IllegalArgumentException for negative deposit");
		} catch (IllegalArgumentException e) {
			assertEquals("Deposit amount must be positive", e.getMessage());
		}
	}

	@Test
	void testWithdraw() {
		account.withdraw(40.0);
		assertEquals(60.0, account.getBalance(), 0.001);
	}

	@Test
	void testWithdrawInsufficientFunds() {
		try {
			account.withdraw(200.0);
			fail("Expected IllegalArgumentException for insufficient funds");
		} catch (IllegalArgumentException e) {
			assertEquals("Insufficient funds", e.getMessage());
		}
	}

	@Test
	void testWithdrawNegativeAmount() {
		try {
			account.withdraw(-5.0);
			fail("Expected IllegalArgumentException for negative withdrawal");
		} catch (IllegalArgumentException e) {
			assertEquals("Withdrawal amount must be positive", e.getMessage());
		}
	}

	@Test
	void testTransferSuccess() {
		BankAccount pedroAccount = new BankAccount("Pedro", 50.0);
		boolean result = account.transfer(pedroAccount, 30.0);

		assertTrue(result);
		assertEquals(70.0, account.getBalance(), 0.001);
		assertEquals(80.0, pedroAccount.getBalance(), 0.001);
	}

	@Test
	void testTransferInsufficientFunds() {
		BankAccount pedroAccount = new BankAccount("Pedro", 50.0);
		boolean result = account.transfer(pedroAccount, 200.0);

		assertFalse(result);
		assertEquals(100.0, account.getBalance(), 0.001);
		assertEquals(50.0, pedroAccount.getBalance(), 0.001);
	}

	@Test
	void testTransferToNullAccount() {
		try {
			account.transfer(null, 50.0);
			fail("Expected IllegalArgumentException for null account transfer");
		} catch (IllegalArgumentException e) {
			assertEquals("Target account cannot be null", e.getMessage());
		}
	}
}
