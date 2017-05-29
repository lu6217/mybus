package com.lu.controller.home;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lu.entity.common.Information;
import com.lu.service.AuthorityService;
import com.lu.service.InformationService;

@Controller
@RequestMapping("/front/home")
public class HomeController {

	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private InformationService informationService;
	
	@RequestMapping("/index")
	public String toHome(HttpServletRequest request,Model model){
		
		List<Information> informations=informationService.getInformationList();
		model.addAttribute("informations", informations);
		model.addAttribute("menus", MenuUtil.getMenus(request));
		return "/view/background/index";
	}
	
	
}
