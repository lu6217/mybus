package com.lu.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lu.entity.schedule.ScheduleSite;
import com.lu.util.BaseDAO;
import com.lu.util.DetachedCriteriaBuilder;

@Repository
public class ScheduleSiteDao extends BaseDAO<ScheduleSite>{

	public ScheduleSite getScheduleSiteByScheduleIdAndSiteId(Long scheduleId, Long siteId) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query=DetachedCriteriaBuilder.instance(ScheduleSite.class);
		query.addEq("scheduleId",scheduleId).addEq("siteId", siteId);
		return this.selectTopOne(query);
	}

	public List<ScheduleSite> getScheduleSiteByTrainId(Long trainId) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query=DetachedCriteriaBuilder.instance(ScheduleSite.class);
		query.addEq("trainId",trainId);
		return select(query);
	}

	public List<ScheduleSite> getScheduleSiteBySiteIdAndTime(Long id, Date date,
			Date date2) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query=DetachedCriteriaBuilder.instance(ScheduleSite.class);
		query.addEq("siteId",id).addBetween("departureTime", date, date2);
		return select(query);
	}

}
