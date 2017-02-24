package com.lu.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.dao.AccountDao;
import com.lu.entity.Account;
import com.lu.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	
	@Override
	@Transactional
	public Serializable save(Account account) {
		// TODO Auto-generated method stub
		return accountDao.save(account);
	}

}
