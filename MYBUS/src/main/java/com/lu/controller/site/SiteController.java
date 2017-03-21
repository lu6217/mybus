package com.lu.controller.site;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.entity.site.Site;
import com.lu.service.SiteService;

@Controller
@RequestMapping("/site")
public class SiteController {

	@Autowired
	private SiteService siteService;
	
	@RequestMapping("/create")
	@ResponseBody
	public String createSite(HttpServletRequest request,Site site){
		String result="";
		if(site!=null){
			if(!siteService.checkName(site.getName())){
				siteService.save(site);
				result="success";
			}else{
				result="false";
			}
		}
		
		return result; 
	}
	
	@RequestMapping("/create/checkname")
	@ResponseBody
	public String checkName(HttpServletRequest request){
		String result=null;
		String name=request.getParameter("name").trim();
		System.out.println(name);
		if(name!=null){
			boolean flag=siteService.checkName(name);
			if(flag){
				result="true";
			}else{
				result="false";
			}
		}
		
		return result;
	}
	
	
}
