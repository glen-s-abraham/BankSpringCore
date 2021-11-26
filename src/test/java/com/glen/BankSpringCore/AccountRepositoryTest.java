package com.glen.BankSpringCore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountRepositoryTest {
	
	AccountRepositoryInterface accRepo;
	@BeforeEach
	void setUp() throws Exception {
		accRepo=new AccountRepository();
	}

	@Test
	void shouldReturnTureWhenCorrectAccountAdded() {
		assertTrue(accRepo.addNewAccount(123L,"Test",60000L));
		assertEquals(accRepo.count(),1);
	}
	
	@Test
	void shouldReturnTrueWhenCorrectAccountIdPassedForDeletion() {
		accRepo.addNewAccount(123L, "test", 2000L);
		assertTrue(accRepo.deleteAccountByAccNo(123L));
		assertEquals(0, accRepo.count());
	}
	
	@Test
	void shouldReturnFalseWhenInCorrectAccountIdPassedForDeletion() {
		accRepo.addNewAccount(123L, "test", 2000L);
		assertFalse(accRepo.deleteAccountByAccNo(124L));
		assertEquals(1, accRepo.count());
	}
	
	@Test
	void shouldRetrunCorrectAccountWhenGivenRightId() {
		accRepo.addNewAccount(123L, "test", 2000L);
		Account expected = new Account(123L, "test", 2000L);
		Account result = accRepo.findByAccNo(123L);
		assertAll(
				()->assertEquals(expected.getAccNo(), result.getAccNo()),
				()->assertEquals(expected.getName(), result.getName()),
				()->assertEquals(expected.getBalance(), result.getBalance())
		);
	}
	@Test
	void shouldRetrunInCorrectAccountWhenGivenWrongId() {
		assertEquals(accRepo.findByAccNo(124L),null);	
	}
	
	@Test
	void shouldUpdateBalanceWhenGivenCorrectParameters() {
		accRepo.addNewAccount(123L, "Test", 60000L);
		Long newBalance=70000L;
		accRepo.findByAccNoAndUpdateBalance(123L, newBalance);
		assertEquals(accRepo.findByAccNo(123L).getBalance(), newBalance);
	}
	
	@Test
	void shouldThrowExceptionWhenGivenInCorrectParameterBalance() {
		accRepo.addNewAccount(123L, "Test", 60000L);
		Long newBalance=-100L;
		assertThrows(ArithmeticException.class,
				()->accRepo.findByAccNoAndUpdateBalance(123L, newBalance));
		
	}
	
	@Test
	void shouldUpdateNameWhenGivenCorrectParameters() {
		accRepo.addNewAccount(123L, "Test", 60000L);
		String newName="Test123";
		accRepo.findByAccNoAndUpdateName(123L, newName);
		assertEquals(accRepo.findByAccNo(123L).getName(), newName);
	}
	
	@Test
	void shouldThrowExceptionWhenGivenInCorrectParameterName() {
		accRepo.addNewAccount(123L, "Test", 60000L);
		String newName="J";
		assertThrows(IllegalArgumentException.class,
				()->accRepo.findByAccNoAndUpdateName(123L, newName));
		
	}
	

}
