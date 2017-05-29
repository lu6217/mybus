package com.lu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.dao.Account_UserDao;
import com.lu.dao.OrderDao;
import com.lu.dao.UserDao;
import com.lu.entity.account.Account;
import com.lu.entity.account.Account_User;
import com.lu.entity.account.User;
import com.lu.entity.order.Order;
import com.lu.entity.vo.UserVo;
import com.lu.service.UserService;
import com.lu.util.PagingVO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired 
	private OrderDao orderDao; 

	@Autowired 
	private Account_UserDao account_UserDao;
	
	@Override
	@Transactional
	public void saveOrUpdateUser(User user) {
		// TODO Auto-generated method stub
		userDao.saveOrUpdate(user);
		
	}

	@Override
	@Transactional
	public PagingVO searchList(PagingVO pagingVo, UserVo userVo) {
		// TODO Auto-generated method stub
		PagingVO vo =pagingVo;
		vo=userDao.searchList(pagingVo,userVo);
		return vo;
	}

	@Override
	@Transactional
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		List<User> lists=userDao.getUserById(id);
		User user=new User();
		if(lists!=null && lists.size()!=0){
			user=lists.get(0);
		}
		return user;
	}

	@Override
	@Transactional
	public void delUser(User user) {
		// TODO Auto-generated method stub
		List<Order> lists=orderDao.getOrderByUserId(user.getId());
		if(lists!=null && lists.size()>0){
			Order order=new Order();
			for (int i = 0; i < lists.size(); i++) {
				order=lists.get(i);
				orderDao.delete(order);
			}
		}
		userDao.delete(user);
		
	}

	
	
	@Override
	@Transactional
	public void delUser(User user, Account account) {
		// TODO Auto-generated method stub
		//删除订单
		List<Order> lists=orderDao.getOrderByUserId(user.getId());
		if(lists!=null && lists.size()>0){
			Order order=new Order();
			for (int i = 0; i < lists.size(); i++) {
				order=lists.get(i);
				orderDao.delete(order);
			}
		}
		//删除账号和用户的关联
		Account_User account_User=account_UserDao.getAccount_UserByAccountIdAndUserId(account.getId(),user.getId());
		if(account_User!=null){
			account_UserDao.delete(account_User);
		}
		userDao.delete(user);
	}

	@Override
	@Transactional
	public List<User> getUserByAccountId(Long accountId) {
		// TODO Auto-generated method stub
		List<Account_User> account_Users=account_UserDao.getAccount_UserByAccountId(accountId);
		List<User> lists=new ArrayList<User>();
		if (account_Users!=null) {
			for (int i = 0; i < account_Users.size(); i++) {
				lists.add(account_Users.get(i).getUser());
			}
			return lists;
		}
		return null;
	}

	@Override
	@Transactional
	public boolean checkIdCard(String IdCard) {
		// TODO Auto-generated method stub
		List<User> lists=userDao.checkIdCard(IdCard);
		if(lists!=null && lists.size()!=0){
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public User getUserByIdCard(String iDcard) {
		// TODO Auto-generated method stub
		List<User> lists=userDao.getUserByIdCard(iDcard);
		if(lists!=null && lists.size()>0){
			return lists.get(0);
		}
		return null;
	}
	
}
