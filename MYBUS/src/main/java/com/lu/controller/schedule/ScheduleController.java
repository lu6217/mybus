package com.lu.controller.schedule;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.entity.train.TrainNumber;
import com.lu.entity.vo.ScheduleVo;
import com.lu.service.ScheduleService;
import com.lu.service.TrainService;
import com.lu.util.PagingVO;
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
	
	
	@RequestMapping("/addallschedule")
	@ResponseBody
	public ResultResponse addAllSchedule(HttpServletRequest request, Model model){
		ResultResponse result = new ResultResponse();
		List<TrainNumber> lists=trainService.getTrain();
		if (lists!=null && lists.size()>0 ) {
			TrainNumber train=new TrainNumber();
			for (int i = 0; i < lists.size(); i++) {
				train=lists.get(i);
				if(train!=null){
					scheduleService.saveScheduleAndSite(train);
					result.setMessage("ok");
				}else{
					result.setMessage("failure");
				}
			}
		}
		//model.addAttribute("accountId", trainId);
		return result;
	}
	
	@RequestMapping("/delschedule")
	@ResponseBody
	public ResultResponse delSchedule(HttpServletRequest request, Model model){
		ResultResponse result = new ResultResponse();
		scheduleService.delExpiredSchedule();
		
		result.setMessage("success");
		return result;
	}
	
	@RequestMapping("/schedulelist")
	public String trainSearchList(PagingVO pagingVo,ScheduleVo scheduleVo,Model model, HttpServletRequest request){
		PagingVO vo =scheduleService.searchList(pagingVo,scheduleVo);
		model.addAttribute("pageVO", vo);
		return "view/background/schedule/schedulelist";
	}
	
	@RequestMapping("/toaddschedule")
	public String toAddSchedule(HttpServletRequest request, Model model){
		
//		model.addAttribute("accountId", trainId);
		return "view/background/schedule/addschedule";
	}
	
	
	@RequestMapping("/addschedule2")
	@ResponseBody
	public ResultResponse addSchedule2(HttpServletRequest request, Model model,ScheduleVo scheduleVo){
		ResultResponse result = new ResultResponse();
		if(scheduleVo==null || scheduleVo.getTrainName()==null || scheduleVo.getStartDate()==null || scheduleVo.getEndDate()==null){
			result.setResult(Boolean.FALSE);
			result.setMessage("Failure!");
		}
		System.out.println(scheduleVo.getTrainName());
		
		TrainNumber train=trainService.getTrainByName(scheduleVo.getTrainName());
		if(train!=null){
			scheduleService.saveScheduleAndSite(train,scheduleVo.getStartDate(),scheduleVo.getEndDate());
			result.setMessage("Success");
		}else{
			result.setMessage("Failure!");
		}
		return result;
	}
	
	
}
