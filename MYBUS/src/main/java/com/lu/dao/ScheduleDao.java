package com.lu.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lu.entity.schedule.Schedule;
import com.lu.entity.vo.ScheduleSearchVo;
import com.lu.util.BaseDAO;
import com.lu.util.DetachedCriteriaBuilder;
import com.lu.util.PagingVO;

@Repository
public class ScheduleDao extends BaseDAO<Schedule>{

	public Schedule getScheduleByIdAndTime(Long id, Date departureDate) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query=DetachedCriteriaBuilder.instance(Schedule.class);
		query.addEq("trainId",id).addEq("departureTime", departureDate);
		
		return this.selectTopOne(query);
	}

	public PagingVO searchList(PagingVO pagingVo,
			ScheduleSearchVo scheduleSearchVo, Long[] scheduleIds) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = initQueryCriteria(scheduleSearchVo,scheduleIds);
		DetachedCriteriaBuilder count = initQueryCriteria(scheduleSearchVo,scheduleIds);
		return this.selectPagingVO(query, pagingVo, count);
	}

	private DetachedCriteriaBuilder initQueryCriteria(
			ScheduleSearchVo scheduleSearchVo,Long[] scheduleIds) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = DetachedCriteriaBuilder.instance(Schedule.class);
		query.addIn("id", scheduleIds);
//		query.addLikeAny("train.number", scheduleSearchVo.getNumber());
		//这个乘车点和目的地站点要在站点列表中查询  通过这两个站点来查出是哪个车次  
//		query.addEq("train.beginSite", trainSearchVo.getBeginSite());
//		query.addEq("train.endSite", trainSearchVo.getEndSite());
		//发车时间在这一天中的车次都要查出来  可能要用  between and 来表示一个范围 来查询车次信息
//		query.addEq("train.departureTime", trainSearchVo.getDepartureTime());
		return query;
	}

	public List<Schedule> getScheduleBySiteIdAndTime(Long id, Date date, Date date2) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query=DetachedCriteriaBuilder.instance(Schedule.class);
		query.addEq("beginSiteId",id).addBetween("departureTime", date, date2);
		return select(query);
	}

	
}
