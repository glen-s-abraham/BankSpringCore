package com.glen.BankSpringCore;

public interface AccountRepositoryInterface {
	public void findByAccNoAndUpdateBalance(Long id, Long updatedAmount);
	public void findByAccNoAndUpdateName(Long id, String updatedName)throws IllegalArgumentException;
	public Account findByAccNo(Long id);
	public boolean addNewAccount(Long accNo,String Name,Long balance);
	public boolean deleteAccountByAccNo(Long id);
	public int count();
	
}
