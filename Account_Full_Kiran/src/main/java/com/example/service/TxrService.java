package com.example.service;

import java.util.List;

public interface TxrService {

	public boolean transfer(double amount, String fromAccNum, String toAccNum);
	public <T> List<T> retrieve(String str);

}