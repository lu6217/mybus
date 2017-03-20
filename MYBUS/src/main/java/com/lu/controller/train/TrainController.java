package com.lu.controller.train;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.entity.train.TrainNumber;
import com.lu.service.TrainService;

@Controller
@RequestMapping("/train")
public class TrainController {

	@Autowired
	private TrainService trainService;
	
	@RequestMapping("/create")
	@ResponseBody
	public String addTrain(HttpServletRequest request,TrainNumber train){
		String result=null;
		trainService.save(train);
		
		return result;
	}
	
}
