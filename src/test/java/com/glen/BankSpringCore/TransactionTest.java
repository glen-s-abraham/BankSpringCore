package com.glen.BankSpringCore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransactionTest {
	Transaction transaction;
	@BeforeEach
	void setUp() {
		transaction=new Transaction();
	}
	
	@Test
	void shouldReturnTrueWhenGivenRightAccountAndAmountToWithdraw() {
		Account account = new Account(123L,"Test",1500L);
		assertTrue(transaction.withdraw(account, 100L));
		assertEquals(account.getBalance(),(1500L-100L));
	}
	
	@Test
	void shouldReturnFalseWhenGivenRightAccountAndWrongAmountToWithdraw() {
		Account account = new Account(123L,"Test",1500L);
		assertFalse(transaction.withdraw(account, 1501L));
	}
	
	@Test
	void shouldReturnTrueWhenGivenRightAccountAndAmountToDeposit() {
		Account account = new Account(123L,"Test",1500L);
		assertTrue(transaction.deposit(account, 100L));
		assertEquals(account.getBalance(),(1500L+100L));
	}
	
	@Test
	void shouldReturnFalseWhenGivenRightAccountAndWrongAmountToDeposit() {
		Account account = new Account(123L,"Test",1500L);
		assertFalse(transaction.deposit(account, -1501L));
	}


}
