package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.example.repository.AccountRepository;
import com.example.service.*;

@Configuration
// @Import(value = { DataSourceConfiguration.class })
@ComponentScan(basePackages = { "com.example.service", "com.example.repository", "com.example.config" })
public class AccountServiceConfiguration {

	@Autowired
	@Qualifier("jdbc")
	private AccountRepository accountRepository;

	@Bean("txrService")
	public TxrService txrService() {
		TxrService txrService = new FinTxrService(accountRepository);
//		txrService.setTxrType("IMPS");
//		txrService.setAccountRepository(accountRepository);
		return txrService;
	}

}