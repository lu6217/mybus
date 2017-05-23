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
	public Seat getOneSeat(Long trainId) {
		// TODO Auto-generated method stub
		//每一个车次都应该有一组自己的座位   之前是所有的车次都使用同一组数据  
		//应该在获得数据的时候，先查看每一车次中那些是空闲的座位 然后 从空闲的座位中取出   先根据车次列出已经分配的座位。再进行分配。
		//
		//		int [][] arr=new int[5][20];
		
		return seatDao.getOneSeat();
	}

	
	
}
