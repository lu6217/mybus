package com.lu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.dao.SiteDao;
import com.lu.dao.Train_SiteDao;
import com.lu.entity.site.Site;
import com.lu.entity.train_site.Train_Site;
import com.lu.entity.vo.ResultVO;
import com.lu.service.SiteService;
import com.lu.util.PagingVO;

@Service
public class SiteServiceImpl implements SiteService{

	@Autowired
	private SiteDao siteDao;
	
	@Autowired
	private Train_SiteDao train_siteDao;
	
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
		if(lists!=null && lists.size()!=0){
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public List<ResultVO> fuzzyQuerySite(String queryKey,String site) {
		// TODO Auto-generated method stub
		return siteDao.fuzzyQuerySite(queryKey,site);
	}

	@Override
	@Transactional
	public Site getSiteByName(String beginSite) {
		// TODO Auto-generated method stub
		List<Site> lists=siteDao.getSiteByName(beginSite);
		Site site=null;
		if(lists!=null && lists.size()!=0){
			site=lists.get(0);
		}
		return site; 
	}

	@Override
	@Transactional
	public List<ResultVO> fuzzyQuerySite2(String queryKey, Long trainId,Long pr) {
		// TODO Auto-generated method stub
		List<Train_Site> lists=train_siteDao.getSitesBytrainId(trainId);
		Long [] sites=null;
		Long endSiteId=null;
		if(lists!=null && lists.size() > 0){
			sites=new Long[lists.size()];
			for (int i = 0; i < lists.size(); i++) {
				sites[i]=lists.get(i).getSiteId();
				if(lists.get(i).getNumber()!=null && lists.get(i).getNumber()==0){
					endSiteId=lists.get(i).getSiteId();
				}
			}
		}
		return siteDao.fuzzyQuerySite(queryKey,sites,pr,endSiteId);
	}

	@Override
	@Transactional
	public PagingVO searchAllSiteList(PagingVO pagingVo) {
		// TODO Auto-generated method stub
		return siteDao.getAllSite(pagingVo);
	}

	@Override
	@Transactional
	public Site getSiteById(Long siteId) {
		// TODO Auto-generated method stub
		List<Site> lists=siteDao.getSiteById(siteId);
		Site site=null;
		if(lists!=null && lists.size()!=0){
			site=lists.get(0);
		}
		return site; 
	}

	
}
