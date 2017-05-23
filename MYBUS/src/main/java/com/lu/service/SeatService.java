package com.lu.service;

import com.lu.entity.seat.Seat;

public interface SeatService {

	void saveOrUpdateSeat(Seat seat);

	Seat getOneSeat(Long trainId);

}
