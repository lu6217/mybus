package com.lu.service;

import com.lu.entity.train.TrainNumber;
import com.lu.entity.vo.ScheduleSearchVo;
import com.lu.util.PagingVO;

public interface ScheduleService {

	void saveScheduleAndSite(TrainNumber train);

	PagingVO searchList(PagingVO pagingVo, ScheduleSearchVo scheduleSearchVo);

	
}
