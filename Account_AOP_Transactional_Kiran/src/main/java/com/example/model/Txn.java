package com.example.model;

import java.time.LocalDateTime;

public class Txn {
	
	private int id;
	private double amount;
	private double closingAmount;
	private String txnDate;
	private TxnType txnType;
	private Account account;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getClosingAmount() {
		return closingAmount;
	}
	public void setClosingAmount(double closingAmount) {
		this.closingAmount = closingAmount;
	}
	public String getTxnDate() {
		return txnDate;
	}
	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}
	public TxnType getTxnType() {
		return txnType;
	}
	public void setTxnType(TxnType txnType) {
		this.txnType = txnType;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

}
