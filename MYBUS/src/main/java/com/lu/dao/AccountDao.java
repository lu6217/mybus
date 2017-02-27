package com.lu.dao;

import java.io.Serializable;
import java.util.List;

import com.lu.entity.Account;

public interface AccountDao {

	public Serializable save(Account acount);

	public List<Account> checkName(String name);
	
}
