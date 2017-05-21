package com.lu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.dao.Account_UserDao;
import com.lu.entity.account.Account_User;
import com.lu.service.Account_UserService;

@Service
public class Account_UserServiceImpl implements Account_UserService{

	@Autowired
	private Account_UserDao account_UserDao;
	
	@Override
	@Transactional
	public void saveOrUpdate(Account_User account_User) {
		// TODO Auto-generated method stub
		account_UserDao.saveOrUpdate(account_User);
	}

	
}
