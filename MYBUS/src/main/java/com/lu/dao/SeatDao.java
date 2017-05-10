package com.lu.dao;

import org.springframework.stereotype.Repository;

import com.lu.entity.seat.Seat;
import com.lu.util.BaseDAO;
import com.lu.util.DetachedCriteriaBuilder;

@Repository
public class SeatDao extends BaseDAO<Seat>{

	public Seat getOneSeat() {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder builder = DetachedCriteriaBuilder.instance(Seat.class,"seat");
		builder.addEq("seat.status", 0L);
		return this.selectTopOne(builder);
	}

}
