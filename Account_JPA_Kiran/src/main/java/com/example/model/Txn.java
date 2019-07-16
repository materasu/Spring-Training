package com.example.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Txns")
public class Txn {
	
	@Override
	public String toString() {
		return "Txn [id=" + id + ", amount=" + amount + ", closingAmount=" + closingAmount + ", txnDate=" + txnDate
				+ ", txnType=" + txnType + ", account=" + account + "]";
	}
	@Id
	@Column(name="txnId")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "txn_id")
	@SequenceGenerator(name = "txn_id", sequenceName = "txn_id", allocationSize = 1)
	private int id;
	@Column(name="txnAmount")
	private double amount;
	@Column(name="closingBalance")
	private double closingAmount;
	@Column(name="txnDate")
	private String txnDate;
	@Column(name="txnType")
	private String txnType;
	
	@ManyToOne
	@JoinColumn(name = "TxnAccountNumber")
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
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

}
