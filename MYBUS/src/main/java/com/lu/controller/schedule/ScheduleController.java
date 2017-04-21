package com.lu.controller.schedule;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.util.ResultResponse;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

	
	@RequestMapping("/addschedule")
	@ResponseBody
	public ResultResponse addSchedule(HttpServletRequest request, Model model){
		ResultResponse result = new ResultResponse();
		Long trainId=Long.parseLong(request.getParameter("trainId").trim());
		System.out.println(trainId);
		result.setMessage("ok");
		//model.addAttribute("accountId", trainId);
		return result;
	}
	
}
