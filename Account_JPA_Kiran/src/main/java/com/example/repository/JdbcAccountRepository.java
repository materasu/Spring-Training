package com.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Account;
import com.example.model.Txn;
@Repository("jdbcAccountRepository")
@Qualifier("jdbc")
public class JdbcAccountRepository implements AccountRepository {

	private static final Logger LOGGER = Logger.getLogger("App");

	private JdbcTemplate jdbcTemplate;

	public JdbcAccountRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		LOGGER.info("JdbcAccountRepository created with datasource");
	}

	@Override
	public Account load(String accNum) {
		LOGGER.info("loading account : " + accNum);
		Account account = new Account();
		String sql = "Select * from Account where accno=?";
		jdbcTemplate.queryForObject(sql, (rs,rowNum)->{
				account.setAccNo(rs.getString("accNo"));
				account.setAmount(rs.getDouble("amount"));
				return account;
		}, accNum);
		LOGGER.info(account);
		return account;
	}

	@Override
	public Account update(Account account) {
		//
		LOGGER.info("updating account : " + account.getAccNo());
		String sql = "update ACCOUNT set amount=? where accno=?";
		int rowCount = jdbcTemplate.update(sql, account.getAmount(), account.getAccNo());
		return account;
	}
	/*
	@Override
	public void add(String accNo) {
		Account account = new Account(accNo);
		try{
			Connection con = dataSource.getConnection();
			String sql = "Insert Into Account (accno) values(?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, account.getAccNo());
			
			ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		LOGGER.info("Account created with accNo = "+accNo);
	}

	@Override
	public void add(String accNo, double amount) {
		Account account = new Account(accNo,amount);
		try{
			Connection con = dataSource.getConnection();
			String sql = "Insert Into Account (accno,amount) values(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, account.getAccNo());
			ps.setDouble(2, account.getAmount());
			ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		LOGGER.info("Account created with accNo = "+accNo+" with amount = "+amount);
	}
	*/

	@Override
	public void add(String accNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(String accNo, double amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Txn txn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> List<T> getAll(String str) {
		// TODO Auto-generated method stub
		return null;
	}
}
