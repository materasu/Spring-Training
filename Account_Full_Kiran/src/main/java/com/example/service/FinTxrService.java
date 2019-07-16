package com.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.*;
import com.example.repository.*;

@Service("txrService")

public class FinTxrService implements TxrService{

	private static final Logger LOGGER = Logger.getLogger("App");
	
	private AccountRepository accountRepository;

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		LOGGER.info("TxrServiceImpl got injection with accountRepository");
	}
	
//	public FinTxrService(AccountRepository accountRepository) {
//		super();
//		this.accountRepository = accountRepository;
//	}

	@Transactional
	
	@Override
	public boolean transfer(double amount, String fromAccNum, String toAccNum) {
		Account fromAcc = accountRepository.load(fromAccNum);
		Account toAcc = accountRepository.load(toAccNum);
		fromAcc.setAmount(fromAcc.getAmount()-amount);
		toAcc.setAmount(toAcc.getAmount()+amount);
		accountRepository.update(fromAcc);
		accountRepository.update(toAcc);
		LOGGER.info("Transfer from "+fromAccNum+" to "+toAccNum+" done.");
		
		Txn debitTxn=new Txn();
		debitTxn.setAccount(fromAcc);
		debitTxn.setAmount(amount);
		debitTxn.setClosingAmount(fromAcc.getAmount());
		debitTxn.setTxnType(TxnType.DEBIT.name());
		debitTxn.setTxnDate(LocalDateTime.now().toString());
		
		
		Txn creditTxn=new Txn();
		creditTxn.setAccount(toAcc);
		creditTxn.setAmount(amount);
		creditTxn.setClosingAmount(toAcc.getAmount());
		creditTxn.setTxnType(TxnType.CREDIT.name());
		creditTxn.setTxnDate(LocalDateTime.now().toString());
		

		accountRepository.save(debitTxn);
		accountRepository.save(creditTxn);
		
		return true;
	}

//  @Override
//	public <T> List<T> retrieve(String str) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
//	@Transactional
	@Override
	public <T> List<T> retrieve(String str)
	{
		return (accountRepository.getAll(str));
	}

}
