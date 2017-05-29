package com.lu.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.dao.OrderDao;
import com.lu.dao.ScheduleDao;
import com.lu.dao.ScheduleSiteDao;
import com.lu.dao.TrainDao;
import com.lu.dao.Train_SiteDao;
import com.lu.entity.enumType.TrainStatus;
import com.lu.entity.order.Order;
import com.lu.entity.schedule.Schedule;
import com.lu.entity.schedule.ScheduleSite;
import com.lu.entity.train.TrainNumber;
import com.lu.entity.train_site.Train_Site;
import com.lu.entity.vo.ResultVO;
import com.lu.entity.vo.TrainSearchVo;
import com.lu.service.TrainService;
import com.lu.util.PagingVO;
@Service
public class TrainServiceImpl implements TrainService{

	@Autowired
	private TrainDao trainDao;
	
	@Autowired
	private Train_SiteDao train_siteDao;
	
	@Autowired
	private ScheduleDao scheduleDao;
	
	@Autowired
	private ScheduleSiteDao scheduleSiteDao;
	
	@Autowired
	private OrderDao orderDao; 
	
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
		
		@SuppressWarnings("unchecked")
		List<TrainNumber> datas = (List<TrainNumber>) vo.getDetails();
		
		for (TrainNumber train : datas) {
			long time=train.getArrivalTime().getTime()+train.getNumberDay()*24*3600*1000-train.getDepartureTime().getTime();
			train.setTime(new Date(time));
			train.setHour(time/(60*60*1000));
			train.setMinute((time%(60*60*1000))/(60*1000));
		}
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
		//删除train时也要把train中的所有站点都删除
		Long trainId=train.getId();
		List<Train_Site> lists=train_siteDao.getSitesBytrainId(trainId);
		if(lists!=null && lists.size()>0){
			Train_Site train_Site=null;
			for(int i=0;i<lists.size();i++){
				train_Site=lists.get(i);
				train_Site.setIsDelete(Boolean.TRUE);
				train_siteDao.update(train_Site);
				//将是否删除的字段 改为TRUE
//				train_siteDao.delete(lists.get(i));
			}
		}
		//还要删除train的调度信息
		List<Schedule> schedules=scheduleDao.getScheduleByTrainId(trainId);
		if(schedules!=null && schedules.size()>0){
			for (int i = 0; i < schedules.size(); i++) {
				scheduleDao.delete(schedules.get(i));
			}
		}
		//删除Site的调度信息
		List<ScheduleSite> scheduleSites=scheduleSiteDao.getScheduleSiteByTrainId(trainId);
		if(scheduleSites!=null && scheduleSites.size()>0){
			for (int i = 0; i < scheduleSites.size(); i++) {
				scheduleSiteDao.delete(scheduleSites.get(i));
			}
		}
		//删除对应车次的订单
		List<Order> orders=orderDao.getOrderByTrainId(trainId);
		if (orders!=null && orders.size()>0) {
			Order order=new Order();
			for(int i=0;i<orders.size();i++){
				order=orders.get(i);
				orderDao.delete(order);
			}
		}
		train.setIsDelete(Boolean.TRUE);
		train.setStatus(TrainStatus.OFF.getStatus());
		trainDao.update(train);
//		将是否删除字段改为TRUE
//		trainDao.delete(train);
	}
	@Override
	@Transactional
	public List<TrainNumber> getTrain() {
		// TODO Auto-generated method stub
		List<TrainNumber> lists=trainDao.getTrain();
		if(lists!=null && lists.size()!=0){
			return lists;
		}
		
		return null;
	}
	@Override
	@Transactional
	public List<ResultVO> fuzzyQueryTrain(String queryKey) {
		// TODO Auto-generated method stub
		
		return trainDao.fuzzyQuerySite(queryKey);
	}

}
