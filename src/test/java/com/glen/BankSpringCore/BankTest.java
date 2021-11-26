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

}
