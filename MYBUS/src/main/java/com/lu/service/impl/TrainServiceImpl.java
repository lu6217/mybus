package com.lu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.dao.TrainDao;
import com.lu.entity.train.TrainNumber;
import com.lu.entity.vo.TrainSearchVo;
import com.lu.service.TrainService;
import com.lu.util.PagingVO;
@Service
public class TrainServiceImpl implements TrainService{

	@Autowired
	private TrainDao trainDao;
	@Override
	@Transactional
	public void saveOrUpdateUser(TrainNumber train) {
		// TODO Auto-generated method stub
		trainDao.saveOrUpdate(train);
		
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
	@Override
	@Transactional
	public PagingVO searchList(PagingVO pagingVo, TrainSearchVo trainSearchVo) {
		// TODO Auto-generated method stub
		PagingVO vo =pagingVo;
		vo=trainDao.searchList(pagingVo,trainSearchVo);
		return vo;
	}
	@Override
	@Transactional
	public TrainNumber getTrainByName(String name) {
		// TODO Auto-generated method stub
		List<TrainNumber> lists=trainDao.getTrainByName(name);
		if(lists!=null && lists.size()!=0){
			return lists.get(0);
		}
		return null;
	}
	@Override
	@Transactional
	public TrainNumber getTrainById(Long id) {
		// TODO Auto-generated method stub
		List<TrainNumber> lists=trainDao.getTrainById(id);
		if(lists!=null && lists.size()!=0){
			return lists.get(0);
		}
		return null;
	}
	@Override
	@Transactional
	public void delTrain(TrainNumber train) {
		// TODO Auto-generated method stub
		trainDao.delete(train);
	}

}
