package com.glen.BankSpringCore;

public class Bank {
	
	private Transaction transaction;
	private AccountRepositoryInterface accRepo;
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public void setAccRepo(AccountRepositoryInterface accRepo) {
		this.accRepo = accRepo;
	}



	public String createAccount(Long accNo,String name,Long amount) {
		boolean isCreated = accRepo.addNewAccount(accNo, name, amount);
		if(isCreated==true)
			return "Account created Successfully with accNo " + accNo;
		return "Failed to create account";
	}
	
	
}
