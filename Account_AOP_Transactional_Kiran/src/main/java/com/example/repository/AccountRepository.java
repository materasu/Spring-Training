package com.example.repository;

import com.example.model.Account;
import com.example.model.*;

public interface AccountRepository {

	void add(String accNo);
	
	void add(String accNo, double amount);
	
	Account load(String accNo);

	Account update(Account account);
	
	void save (Txn txn);
	
	

}
