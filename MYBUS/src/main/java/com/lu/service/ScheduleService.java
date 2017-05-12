package com.lu.service;

import java.util.Date;

import com.lu.entity.train.TrainNumber;
import com.lu.entity.vo.ScheduleSearchVo;
import com.lu.entity.vo.ScheduleVo;
import com.lu.util.PagingVO;

public interface ScheduleService {

	void saveScheduleAndSite(TrainNumber train);

	PagingVO searchList(PagingVO pagingVo, ScheduleSearchVo scheduleSearchVo);

	void delExpiredSchedule();

	PagingVO searchList(PagingVO pagingVo, ScheduleVo scheduleVo);

	void saveScheduleAndSite(TrainNumber train, Date startDate, Date endDate);

	
}
