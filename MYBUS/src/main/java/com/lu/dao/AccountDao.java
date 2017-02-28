package com.lu.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lu.entity.Account;
import com.lu.util.BaseDAO;
import com.lu.util.DetachedCriteriaBuilder;

@Repository
public class AccountDao extends BaseDAO<Account>{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<Account> checkName(String name) {
		// TODO Auto-generated method stub
		
		DetachedCriteriaBuilder query=DetachedCriteriaBuilder.instance(Account.class);
		query.addEq("name",name);
		
		return this.select(query);
	}


	public List<Account> findByNmae(String name) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query=DetachedCriteriaBuilder.instance(Account.class);
		query.addEq("name",name);
		return this.select(query);
	}

	
}
