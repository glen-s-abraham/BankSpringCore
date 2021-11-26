package com.glen.BankSpringCore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class BankTest {
	public Bank bank;
	@BeforeEach
	void setUp() {
        bank = new Bank();
        bank.setAccRepo(new AccountRepository());
        bank.setTransaction(new Transaction());
	}
	
	@Test
	void shouldReturnAccountCreatedIfPassedRightArguements() {
		assertEquals(bank.createAccount(123L, "Name", 123L), 
				"Account created Successfully with accNo " + 123L);
	}
	
	@Test
	void shouldAddMoneyIfGivenRightDetails() {
		bank.createAccount(123L, "Test", 1500L);
		assertEquals(bank.addMoney(123L, 100L), "Money Added");
	}
	
	@Test
	void shouldNotAddMoneyIfGivenWrongAccountRightAmount() {
		bank.createAccount(123L, "Test", 1500L);
		assertEquals(bank.addMoney(124L, 100L), "invalid accNo");
	}
	
	@Test
	void shouldNotAddMoneyIfGivenRightAccountWrongAmount() {
		bank.createAccount(123L, "Test", 1500L);
		assertEquals(bank.addMoney(123L, -100L), "Money Not Added");
	}
	
	@Test
	void shouldWithdrawMoneyIfGivenRightDetails() {
		bank.createAccount(123L, "Test", 1500L);
		assertEquals(bank.drawMoney(123L, 100L), "Money Withdrawn");
	}
	
	@Test
	void shouldNotWithdrawMoneyIfGivenWrongAccountRightAmount() {
		bank.createAccount(123L, "Test", 1500L);
		assertEquals(bank.drawMoney(124L, 100L), "invalid accNo");
	}
	
	@Test
	void shouldNotWithdrawMoneyIfGivenRightAccountWrongAmount() {
		bank.createAccount(123L, "Test", 1500L);
		assertEquals(bank.drawMoney(123L, 1501L), "Money Not Withdrawn");
	}
	

}
