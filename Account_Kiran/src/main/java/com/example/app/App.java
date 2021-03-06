package com.example.app;

import com.example.repository.*;
import com.example.service.*;
import com.example.config.*;
import com.example.model.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class App {

	private static final Logger LOGGER = Logger.getLogger("App");

	public static void main(String[] args) {

		// -------------------------------------
		// init / boot
		// -------------------------------------
		ConfigurableApplicationContext context = null;
		context = new AnnotationConfigApplicationContext(AccountServiceConfiguration.class);

		LOGGER.info("This is Java Config using Transactional");
		LOGGER.info("app init/booted..");
		System.out.println();
		// -------------------------------------
		// use
		// -------------------------------------
		LOGGER.info("app in use");
		TxrService txrService = context.getBean("txrService", TxrService.class);
		txrService.transfer(150.00, "1", "2");

		List<Txn> ls = txrService.retrieve("Txns");
		
//		JdbcAccountRepository jdbc = context.getBean("JdbcAccountRepository", JdbcAccountRepository.class);
//		jdbc.add("3");
//		jdbc.add("4",5000.00);
		System.out.println();

		System.out.println();
		// -------------------------------------
		// destroy
		// -------------------------------------
		LOGGER.info("app destroyed");
		context.close();
		// -------------------------------------
	}

}