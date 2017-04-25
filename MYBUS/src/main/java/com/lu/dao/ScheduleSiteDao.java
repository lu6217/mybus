package com.lu.dao;

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

}
