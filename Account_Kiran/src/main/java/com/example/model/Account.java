package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account {

	@Id
	@Column(name="AccNo")
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
