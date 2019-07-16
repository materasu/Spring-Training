package com.example.app;

import com.example.repository.*;
import com.example.service.*;
import com.example.model.*;


import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class App {

	private static final Logger LOGGER = Logger.getLogger("App");

	public static void main(String[] args) {

		// -------------------------------------
		// init / boot
		// -------------------------------------
		ConfigurableApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("account-service2.xml");

		LOGGER.info("app init/booted..");
		System.out.println();
		// -------------------------------------
		// use
		// -------------------------------------
		LOGGER.info("app in use");
		TxrService txrService = context.getBean("txrService", TxrService.class);
		txrService.transfer(100.00, "4", "2");

		
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