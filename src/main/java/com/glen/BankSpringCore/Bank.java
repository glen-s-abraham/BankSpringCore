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
	
	public String addMoney(Long accNo,Long amount) {
		Account account=accRepo.findByAccNo(accNo);
		if(account==null)
			return "invalid accNo";
		boolean isDeposited = transaction.deposit(account, amount);
		if(isDeposited)
			return "Money Added";
		else
			return "Money Not Added";
	}
	
	public String drawMoney(Long accNo,Long amount) {
		Account account=accRepo.findByAccNo(accNo);
		if(account==null)
			return "invalid accNo";
		boolean isWithdrawn = transaction.withdraw(account, amount);
		if(isWithdrawn)
			return "Money Withdrawn";
		else
			return "Money Not Withdrawn";
	}
	
	
}
