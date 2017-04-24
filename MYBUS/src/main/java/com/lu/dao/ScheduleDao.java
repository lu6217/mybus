package com.lu.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.lu.entity.schedule.Schedule;
import com.lu.util.BaseDAO;
import com.lu.util.DetachedCriteriaBuilder;

@Repository
public class ScheduleDao extends BaseDAO<Schedule>{

	public Schedule getScheduleByIdAndTime(Long id, Date departureDate) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query=DetachedCriteriaBuilder.instance(Schedule.class);
		query.addEq("trainId",id).addEq("departureTime", departureDate);
		
		return this.selectTopOne(query);
	}

}
