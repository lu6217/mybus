package com.lu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.dao.SeatDao;
import com.lu.entity.seat.Seat;
import com.lu.service.SeatService;

@Service
public class SeatServiceImpl implements SeatService{

	@Autowired
	private SeatDao seatDao;
	
	@Override
	@Transactional
	public void saveOrUpdateSeat(Seat seat) {
		// TODO Auto-generated method stub
		
		seatDao.saveOrUpdate(seat);
		
	}

	@Override
	@Transactional
	public Seat getOneSeat() {
		// TODO Auto-generated method stub
		
		return seatDao.getOneSeat();
	}

	
	
}
