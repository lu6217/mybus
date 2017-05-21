package com.lu.controller.home;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lu.entity.account.Account;
import com.lu.entity.authority.Menu;
import com.lu.entity.authority.Role;
import com.lu.service.AuthorityService;

@Controller
@RequestMapping("/front/home")
public class HomeController {

	@Autowired
	private AuthorityService authorityService;
	
	@RequestMapping("/index")
	public String toHome(HttpServletRequest request,Model model){
		Account account = (Account)request.getSession().getAttribute("account");
		if(account!=null){
			Long number=account.getType();
			Role role=authorityService.getRoleByNumber(number);
			if(role!=null){
				List<Menu> menus=authorityService.getMenuByRoleId(role.getId());
				model.addAttribute("menus", menus);
			}
		}
		return "/view/background/index";
	}
	
	
}
