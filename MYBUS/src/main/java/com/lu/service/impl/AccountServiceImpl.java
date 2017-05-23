package com.lu.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.dao.AccountDao;
import com.lu.entity.account.Account;
import com.lu.entity.vo.AccountSearchVo;
import com.lu.service.AccountService;
import com.lu.util.PagingVO;
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	
	@Override
	//@Transactional
	public Serializable save(Account account) {
		// TODO Auto-generated method stub
		return accountDao.save(account);
	}

	@Override
	public boolean checkName(String name) {
		// TODO Auto-generated method stub
		List<Account> lists=accountDao.checkName(name);
		if(lists!=null && lists.size()!=0){
			return true;
		}
		return false;
	}

	@Override
	public Account findByName(String name) {
		// TODO Auto-generated method stub
		Account account=null;
		List<Account> lists=accountDao.findByNmae(name);
		if(lists!=null && lists.size() > 0){
			account=lists.get(0);
		}
		return account;
	}

	@Override
	@Transactional
	public PagingVO searchList(PagingVO pagingVo, AccountSearchVo accountVo) {
		// TODO Auto-generated method stub
		PagingVO vo =pagingVo;
		vo=accountDao.searchList(pagingVo,accountVo);
		return vo;
	}

	@Override
	@Transactional
	public Account findById(Long accountId) {
		// TODO Auto-generated method stub
		Account account=null;
		List<Account> lists=accountDao.findById(accountId);
		if(lists!=null && lists.size()>0){
			account=lists.get(0);
		}
		return account;
	}

	@Override
	@Transactional
	public boolean updateAccountType(Account account) {
		// TODO Auto-generated method stub
		accountDao.update(account);
		
		return true;
	}

	@Override
	@Transactional
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		accountDao.update(account);
	}


}
