package com.lu.controller.seat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lu.entity.seat.Seat;
import com.lu.service.SeatService;

@Controller
@RequestMapping("/seat")
public class SeatController {

	@Autowired
	private SeatService seatService;
	
	@RequestMapping("/addseat")
	public String addSeat(Model model,HttpServletRequest request){
		for (Long i = 1L; i <= 5; i++) {
			for(Long j=1L;j<=20;j++){
				Seat seat=new Seat();
				seat.setCompartmentNumber(i);
				seat.setSeatNumber(j);
				seatService.saveOrUpdateSeat(seat);
			}
		}		
		return null;
	}
	
	
}
