package com.lu.controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lu.entity.common.Information;
import com.lu.service.InformationService;

@Controller
@RequestMapping("/front/information")
public class FrontInformationController {
	
	@Autowired
	private InformationService informationService;
	
	@RequestMapping("/getinformation/{id}")
	private String getInformation(@PathVariable("id")Long id, Model model){
		Information information=informationService.getInformationById(id);
		model.addAttribute("information", information);
		//页面中还没有显示   还要再写
		return "view/background/information/informationdetails";
	}
	
	
}
