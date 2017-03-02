package com.lu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.dao.UserDao;
import com.lu.entity.User;
import com.lu.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public void saveOrUpdateUser(User user) {
		// TODO Auto-generated method stub
		userDao.saveOrUpdate(user);
		
	}
	
}
