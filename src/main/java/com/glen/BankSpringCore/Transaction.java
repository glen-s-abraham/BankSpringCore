package com.glen.BankSpringCore;

public class Transaction {
	
	public boolean withdraw(Account account,Long withdrawAmount) {
		if(account.getBalance()-withdrawAmount<100 || account==null)
			return false;
		account.setBalance(account.getBalance()-withdrawAmount);
		return true;
	} 
	
	public boolean deposit(Account account,Long depositAmount) {
		if(account!=null && depositAmount>1) {
			account.setBalance(account.getBalance()+depositAmount);
			return true;
		}
		return false;
	}
}
