package com.lu.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lu.entity.train.TrainNumber;
import com.lu.service.ScheduleService;
import com.lu.service.TrainService;

@Component
public class ScheduleJob {

	@Autowired
	private TrainService trainService;
	
	@Autowired
	private ScheduleService scheduleService;
	
	//每天晚上23点自动触发
	@Scheduled(cron="0 0 23 * * ?")
	@Transactional
	public void execute(){
		List<TrainNumber> lists=trainService.getTrain();
		if (lists!=null && lists.size()>0 ) {
			TrainNumber train=new TrainNumber();
			for (int i = 0; i < lists.size(); i++) {
				train=lists.get(i);
				if(train!=null){
					scheduleService.saveScheduleAndSite(train);
				}
			}
		}
	}
}
