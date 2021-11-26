package com.glen.BankSpringCore;

public class Transaction {
	public void Withdraw(Account account,Long withdrawAmount) {
		account.setBalance(withdrawAmount);
	} 
	public void deposit(Account account,Long depositAmount) {
		account.setBalance(depositAmount);
	}
}
