package com.example.model;



public class Account {
	
	private String accNo;
	private double amount;
	
	public Account() {
	}

	public Account(String accNo) {
		super();
		this.accNo = accNo;
	}
	
	public Account(String accNo, double amount) {
		super();
		this.accNo = accNo;
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", amount=" + amount + "]";
	}



	
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
