package com.lu.controller.home;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lu.service.AuthorityService;

@Controller
@RequestMapping("/front/home")
public class HomeController {

	@Autowired
	private AuthorityService authorityService;
	
	@RequestMapping("/index")
	public String toHome(HttpServletRequest request,Model model){
		model.addAttribute("menus", MenuUtil.getMenus(request));
		return "/view/background/index";
	}
	
	
}
