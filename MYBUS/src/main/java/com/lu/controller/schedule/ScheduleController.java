package com.lu.controller.schedule;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.entity.train.TrainNumber;
import com.lu.service.ScheduleService;
import com.lu.service.TrainService;
import com.lu.util.ResultResponse;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private TrainService trainService;
	
	@RequestMapping("/addschedule")
	@ResponseBody
	public ResultResponse addSchedule(HttpServletRequest request, Model model){
		ResultResponse result = new ResultResponse();
		Long trainId=Long.parseLong(request.getParameter("trainId").trim());
		TrainNumber train=trainService.getTrainById(trainId);
		if(train!=null){
			scheduleService.saveScheduleAndSite(train);
			result.setMessage("ok");
		}else{
			result.setMessage("failure");
		}
		//model.addAttribute("accountId", trainId);
		return result;
	}
	
}
