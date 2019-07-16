package com.example.repository;

import java.util.List;

import com.example.model.Account;
import com.example.model.Txn;

public interface AccountRepository {

	void add(String accNo);
	
	void add(String accNo, double amount);
	
	Account load(String accNo);

	Account update(Account account);
	
	void save(Txn txn);

	public <T> List<T> getAll(String str);
	

}
