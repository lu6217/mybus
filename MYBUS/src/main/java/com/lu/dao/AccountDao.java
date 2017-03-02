package com.lu.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lu.entity.Account;
import com.lu.entity.vo.AccountSearchVo;
import com.lu.util.BaseDAO;
import com.lu.util.DetachedCriteriaBuilder;
import com.lu.util.PagingVO;

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


	public PagingVO searchList(PagingVO pagingVo, AccountSearchVo accountVo) {
		// TODO Auto-generated method stub
		
		DetachedCriteriaBuilder query = initQueryCriteria(accountVo);
		DetachedCriteriaBuilder count = initQueryCriteria(accountVo);
		return this.selectPagingVO(query, pagingVo, count);
	}


	private DetachedCriteriaBuilder initQueryCriteria(AccountSearchVo accountVo) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = DetachedCriteriaBuilder.instance(Account.class, "ac");
		query.addLikeAny("ac.name", accountVo.getName());
		query.addEq("ac.type", accountVo.getType());
		return query;
	}


	public List<Account> findById(Long id) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query=DetachedCriteriaBuilder.instance(Account.class);
		query.addEq("id",id);
		return this.select(query);
	}

	
}
