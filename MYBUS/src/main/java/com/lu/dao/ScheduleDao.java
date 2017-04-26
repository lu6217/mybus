package com.lu.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.lu.entity.schedule.Schedule;
import com.lu.entity.vo.ScheduleSearchVo;
import com.lu.entity.vo.view.ScheduleView;
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
//		setProjectionInfo(query);
		return this.selectPagingVO(query, pagingVo, count);
	}

	private void setProjectionInfo(DetachedCriteriaBuilder dcb){
		dcb.setProjection(Projections.property("id"), "id");
		dcb.setProjection(Projections.property("train"), "train");
//		dcb.setProjection(Projections.property("departureTime"), "departureTime");
//		dcb.setProjection(Projections.property("arrivalTime"), "arrivalTime");
//		dcb.setProjection(Projections.property("numberDay"), "numberDay");
//		dcb.setProjection(Projections.property("beginSite"), "beginSite");
//		dcb.setProjection(Projections.property("endSite"), "endSite");
//		dcb.setProjection(Projections.property("price"), "price");
//		dcb.setProjection(Projections.property("scheduleMessage"),"scheduleMessage");
		dcb.addDTOTransform(ScheduleView.class);
	}
	
	private DetachedCriteriaBuilder initQueryCriteria(
			ScheduleSearchVo scheduleSearchVo,Long[] scheduleIds) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = DetachedCriteriaBuilder.instance(Schedule.class,"schedule");
		query.leftJoin("schedule.train","train")
		.leftJoin("schedule.beginSite", "beginsite").leftJoin("schedule.endSite", "endsite");
		
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

	public List<Schedule> getScheduleByTrainId(Long trainId) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query=DetachedCriteriaBuilder.instance(Schedule.class);
		query.addEq("trainId",trainId);
		return select(query);
	}

	
}
