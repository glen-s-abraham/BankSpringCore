package com.glen.BankSpringCore;

public class Account {
	private Long accNo;
	private String name;
	private Long balance;
	public Account() {
		
	}
	public Account(Long accNo, String name, Long balance) {
		this.accNo = accNo;
		this.name = name;
		this.balance = balance;
	}
	public Long getAccNo() {
		return accNo;
	}
	public void setAccNo(Long accNo) {
		this.accNo = accNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", name=" + name + ", balance=" + balance + "]";
	}
	
	
	
}
