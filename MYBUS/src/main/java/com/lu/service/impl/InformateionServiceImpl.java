package com.lu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.dao.InformationDao;
import com.lu.entity.common.Information;
import com.lu.entity.vo.InformationVo;
import com.lu.service.InformationService;
import com.lu.util.PagingVO;
@Service
public class InformateionServiceImpl implements InformationService{

	@Autowired
	private InformationDao informationDao;
	
	@Override
	@Transactional
	public PagingVO searchList(PagingVO pagingVo, InformationVo informationVo) {
		// TODO Auto-generated method stub
		PagingVO pageVO=informationDao.getAllInformation(pagingVo);
		
		return pageVO;
	}

	@Override
	@Transactional
	public boolean saveOrUpdate(Information information) {
		// TODO Auto-generated method stub
		informationDao.saveOrUpdate(information);
		return true;
	}

	@Override
	@Transactional
	public Information getInformationById(Long id) {
		// TODO Auto-generated method stub
		Information information=informationDao.getInformationById(id);
		return information;
	}

	@Override
	@Transactional
	public List<Information> getInformationList() {
		// TODO Auto-generated method stub
		List<Information> informations=informationDao.getInformationList();
		if(informations!=null){
			return informations;
		}
		return null;
	}

}
