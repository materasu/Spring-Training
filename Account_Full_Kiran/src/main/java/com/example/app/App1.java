    
package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.config.*;
import com.example.service.*;

public class App1 {

	public static void main(String[] args) {

		// -------------------------------------
		// init / boot
		// -------------------------------------

		ConfigurableApplicationContext context = null;
		context = SpringApplication.run(AccountServiceConfiguration.class, args);

		// -------------------------------------
		// use
		// -------------------------------------

		TxrService txrService = context.getBean(TxrService.class);
		txrService.transfer(100.00, "1", "2");
		System.out.println("DONE!!!!!!!");
//		String sub1 = context.getBean("sub1", String.class);
//		System.out.println(sub1);

		// -------------------------------------
		// destroy
		// -------------------------------------
		context.close();
		// -------------------------------------
	}

}