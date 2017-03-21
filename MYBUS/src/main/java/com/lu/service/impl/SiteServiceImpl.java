package com.lu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.dao.SiteDao;
import com.lu.entity.site.Site;
import com.lu.service.SiteService;

@Service
public class SiteServiceImpl implements SiteService{

	@Autowired
	private SiteDao siteDao;
	
	@Override
	@Transactional
	public void save(Site site) {
		// TODO Auto-generated method stub
		
		siteDao.save(site);
	}

	@Override
	@Transactional
	public boolean checkName(String name) {
		// TODO Auto-generated method stub
		List<Site> lists=siteDao.getSiteByName(name);
		if(lists!=null){
			return true;
		}
		return false;
	}

	
}
