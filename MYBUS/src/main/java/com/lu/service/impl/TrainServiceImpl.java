package com.lu.service.impl;

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

}
