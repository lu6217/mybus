package com.lu.controller.front;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lu.entity.vo.ScheduleSearchVo;
import com.lu.service.ScheduleService;
import com.lu.service.TrainService;
import com.lu.util.PagingVO;

@Controller
@RequestMapping("/front/train")
public class FrontTrainController {
	
	
	@Autowired
	private TrainService trainService;
	
	@Autowired
	private ScheduleService scheduleService;
	
	@RequestMapping("/searchlist")
	public String addTrainSite(PagingVO pagingVo,HttpServletRequest request,ScheduleSearchVo scheduleSearchVo,Model model){
//		System.out.println("kk");
		PagingVO vo =scheduleService.searchList(pagingVo, scheduleSearchVo);
		model.addAttribute("pageVO", vo);
		return "view/front/trainlist_date";
	}
}
