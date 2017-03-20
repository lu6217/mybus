package com.lu.service;

import java.io.Serializable;

import com.lu.entity.account.Account;
import com.lu.entity.vo.AccountSearchVo;
import com.lu.util.PagingVO;

public interface AccountService {

	public Serializable save(Account account);

	public boolean checkName(String name);

	public Account findByName(String name);

	public PagingVO searchList(PagingVO pagingVo, AccountSearchVo accountVo);

	public Account findById(Long accountId);

	public boolean updateAccountType(Account account);

}
