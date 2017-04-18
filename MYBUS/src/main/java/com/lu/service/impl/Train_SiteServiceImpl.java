package com.lu.service.impl;

import java.util.List;

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
	public void saveOrUpdate(Train_Site train_Site) {
		// TODO Auto-generated method stub
		train_siteDao.saveOrUpdate(train_Site);
	}

	@Override
	@Transactional
	public Train_Site getTrainSiteByTrainIdAndSiteId(Long trainId, Long siteId) {
		// TODO Auto-generated method stub
		List<Train_Site> list=train_siteDao.getTrainSiteByTrainIdAndSiteId(trainId,siteId);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}


	@Override
	@Transactional
	public void saveAndChange(Train_Site train_Site, Long trainId, Long number) {
		// TODO Auto-generated method stub
		List<Train_Site> lists=train_siteDao.getTrainSite(trainId,number);
		if(lists!=null && lists.size() > 0){
			Train_Site train_Site2=new Train_Site();
			for(int i=0;i<lists.size();i++){
				//现在这种做法效率不高  以后可能要改    把前一站点和后一站点都加上 
				//获得到number为number+1的信息 然后设置它的前一站点为新添加站点  
				train_Site2=lists.get(i);
				train_Site2.setNumber(train_Site2.getNumber()+1);
				train_siteDao.saveOrUpdate(train_Site2);
			}
		}
		train_siteDao.save(train_Site);
	}

	@Override
	@Transactional
	public Train_Site getTrainSiteByTrainIdAndNumber(Long trainId, long number) {
		// TODO Auto-generated method stub
		List<Train_Site> lists=train_siteDao.getTrainSiteByTrainIdAndNumber(trainId,number);
		if(lists!=null && lists.size() > 0){
		return lists.get(0);
		}
		return null;
	}

	@Override
	@Transactional
	public List<Train_Site> getTrainSiteById(Long id) {
		// TODO Auto-generated method stub
		
		List<Train_Site> lists=train_siteDao.getSitesBytrainId(id);
		if(lists!=null && lists.size()>0){
			Train_Site train_Site=lists.get(0);
			lists.remove(0);
			lists.add(train_Site);
		}
		return lists;
	}

}
