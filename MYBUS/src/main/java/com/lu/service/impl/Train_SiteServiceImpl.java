package com.lu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.dao.Train_SiteDao;
import com.lu.entity.train_site.Train_Site;
import com.lu.service.Train_SiteService;
@Service
public class Train_SiteServiceImpl implements Train_SiteService{

	@Autowired
	private Train_SiteDao train_siteDao;
	
	@Override
	@Transactional
	public void save(Train_Site train_Site) {
		// TODO Auto-generated method stub
		train_siteDao.save(train_Site);
		
	}

}
