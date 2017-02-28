package com.lu.service;

import java.io.Serializable;

import com.lu.entity.Account;

public interface AccountService {

	public Serializable save(Account account);

	public boolean checkName(String name);

	public Account findByName(String name);
	
}
