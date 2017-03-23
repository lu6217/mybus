package com.lu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.dao.TrainDao;
import com.lu.entity.train.TrainNumber;
import com.lu.service.TrainService;
@Service
public class TrainServiceImpl implements TrainService{

	@Autowired
	private TrainDao trainDao;
	@Override
	@Transactional
	public void save(TrainNumber train) {
		// TODO Auto-generated method stub
		trainDao.save(train);
		
	}
	@Override
	@Transactional
	public boolean checkName(String name) {
		// TODO Auto-generated method stub
		List<TrainNumber> lists=trainDao.getTrainByName(name);
		if(lists!=null && lists.size()!=0){
			return true;
		}
		return false;
	}

}
