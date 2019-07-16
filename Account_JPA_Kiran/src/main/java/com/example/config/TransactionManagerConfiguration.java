package com.example.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

//import com.example.service.EntityManagerFactory;
//import com.example.service.JpaTransactionManager;

@Configuration
public class TransactionManagerConfiguration {

	@Autowired
	private DataSource dataSource;

//	@Bean
//	public JdbcTemplate jdbcTemplate() {
//		JdbcTemplate jdbcTemplate = new JdbcTemplate();
//		jdbcTemplate.setDataSource(dataSource);
//		return jdbcTemplate;
//	}

//	@Bean
//	public PlatformTransactionManager jpaTxnManager(EntityManagerFactory emf) {
//		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
//		jpaTransactionManager.setEntityManagerFactory(emf);
//		return jpaTransactionManager;
//	}

}