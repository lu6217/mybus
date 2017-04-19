package com.lu.controller.train_site;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lu.entity.train_site.Train_Site;
import com.lu.service.Train_SiteService;

@Controller
@RequestMapping("/train_site")
public class Train_SiteController {

	@Autowired
	private Train_SiteService train_SiteService;
	
	@RequestMapping("/get/{id}")
	public String getSiteList(@PathVariable("id")Long id, Model model){
		System.out.println(id);
		
		List<Train_Site> lists=train_SiteService.getTrainSiteById(id);
		model.addAttribute("train_sites", lists);
		return "view/background/train/trainsitelist";
	}
}
