package com.example.service;

import org.apache.log4j.Logger;
import com.example.repository.*;

public class AccountCreation {
	
	private static final Logger LOGGER = Logger.getLogger("Lol");
	private AccountRepository accountRepository;
	
	AccountCreation(AccountRepository accountRepository)
	{
		this.accountRepository = accountRepository;
	}
	
	public void CreateNewAccount()
	{
		
	}

}
