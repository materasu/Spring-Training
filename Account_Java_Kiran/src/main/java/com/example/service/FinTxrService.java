package com.example.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.model.*;
import com.example.repository.*;

@Service("txrService")

public class FinTxrService implements TxrService{

	private static final Logger LOGGER = Logger.getLogger("App");
	
	
	@Autowired
	@Qualifier(value="jdbc")
	
	private AccountRepository accountRepository;

	
	public FinTxrService(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

//	@Transactional
	@Override
	public boolean transfer(double amount, String fromAccNum, String toAccNum) {
		Account fromAcc = accountRepository.load(fromAccNum);
		Account toAcc = accountRepository.load(toAccNum);
		fromAcc.setAmount(fromAcc.getAmount()-amount);
		toAcc.setAmount(toAcc.getAmount()+amount);
		accountRepository.update(fromAcc);
		accountRepository.update(toAcc);
		LOGGER.info("Transfer from "+fromAccNum+" to "+toAccNum+" done.");
		return true;
	}
	

}
