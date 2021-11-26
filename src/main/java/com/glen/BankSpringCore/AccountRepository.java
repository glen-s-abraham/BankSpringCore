package com.glen.BankSpringCore;

import java.util.ArrayList;
import java.util.List;

import javax.management.InvalidAttributeValueException;
import javax.naming.directory.InvalidAttributesException;

public class AccountRepository implements AccountRepositoryInterface{
	
	private List <Account> accounts = new ArrayList<Account>();
	
	private Account getById(Long id) {
		for(Account account:accounts)
			if(account.getAccNo() == id)
				return account;
		return null;
	}

	public void findByAccNoAndUpdateBalance(Long id, Long updatedAmount) {
		if(updatedAmount<0 && getById(id)!=null)
			throw new ArithmeticException("Balance can't be negative");	
		getById(id).setBalance(updatedAmount);
	}

	public void findByAccNoAndUpdateName(Long id, String updatedName) throws IllegalArgumentException {
		if(updatedName.length()<3 && getById(id)!=null)
			throw new IllegalArgumentException("ivalid name");
		getById(id).setName(updatedName);
	}

	public Account findByAccNo(Long id) {
		return getById(id);
	}

	public boolean addNewAccount(Long accNo,String Name,Long balance) {
		accounts.add(new Account(accNo,Name,balance));
		return true;
	}

	public boolean deleteAccountByAccNo(Long id) {
		Account account = getById(id);
		
		if(account!=null) {
			return accounts.remove(account);
		}
		return false;
	}
	
	public int count() {
		return accounts.size();
	}
}
