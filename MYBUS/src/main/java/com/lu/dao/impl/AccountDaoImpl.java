package com.lu.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lu.dao.AccountDao;
import com.lu.entity.Account;
@Repository 
public class AccountDaoImpl implements AccountDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Serializable save(Account account) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.save(account);
	}

	

}
