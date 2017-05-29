package com.lu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lu.entity.account.Account_User;
import com.lu.util.BaseDAO;
import com.lu.util.DetachedCriteriaBuilder;

@Repository
public class Account_UserDao extends BaseDAO<Account_User>{

	public List<Account_User> getAccount_UserByAccountId(Long accountId) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query=DetachedCriteriaBuilder.instance(Account_User.class,"account_user");
		query.leftJoin("account_user.account", "account").leftJoin("account_user.user", "user");
		query.addEq("account_user.accountId",accountId);
		return this.select(query);
	}

	public Account_User getAccount_UserByAccountIdAndUserId(Long accountId, Long userId) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query=DetachedCriteriaBuilder.instance(Account_User.class,"account_user");
		query.addEq("account_user.accountId",accountId).addEq("account_user.userId", userId);
		return this.selectTopOne(query);
	}

	
}
