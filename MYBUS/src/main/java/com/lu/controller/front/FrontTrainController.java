package com.lu.controller.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lu.entity.account.Account;
import com.lu.entity.authority.Menu;
import com.lu.entity.authority.Role;
import com.lu.entity.vo.ScheduleSearchVo;
import com.lu.service.AuthorityService;
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
	
	@Autowired
	private AuthorityService authorityService;
	
	@RequestMapping("/searchlist")
	public String addTrainSite(PagingVO pagingVo,HttpServletRequest request,ScheduleSearchVo scheduleSearchVo,Model model){
		PagingVO vo =scheduleService.searchList(pagingVo, scheduleSearchVo);
		model.addAttribute("pageVO", vo);
		return "view/front/trainlist_date";
	}
	
	@RequestMapping("/booking")
	public String booking(HttpServletRequest request,Model model){
		
		Account account = (Account)request.getSession().getAttribute("account");
		if(account!=null){
			Long number=account.getType();
			Role role=authorityService.getRoleByNumber(number);
			if(role!=null){
				List<Menu> menus=authorityService.getMenuByRoleId(role.getId());
				model.addAttribute("menus", menus);
			}
		}
		
		return "view/front/trainlist";
	}
}
