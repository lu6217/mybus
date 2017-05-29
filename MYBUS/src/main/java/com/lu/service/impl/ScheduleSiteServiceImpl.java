package com.lu.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.dao.ScheduleSiteDao;
import com.lu.entity.schedule.ScheduleSite;
import com.lu.service.ScheduleSiteService;
@Service
public class ScheduleSiteServiceImpl implements ScheduleSiteService{

	@Autowired
	private ScheduleSiteDao scheduleSiteDao;
	
	@Override
	@Transactional
	public Long getScheduleId(Long trainId, Long beginSiteId, Date departureTime) {
		// TODO Auto-generated method stub
		ScheduleSite scheduleSite=scheduleSiteDao.getScheduleSiteByTrainIdBeginSiteIdAndDepartureTime(trainId, beginSiteId,departureTime);
		if(scheduleSite!=null){
			return scheduleSite.getScheduleId();
		}
		return null;
	}

}
