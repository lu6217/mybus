package com.lu.controller.site;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.entity.site.Site;
import com.lu.entity.vo.ResultVO;
import com.lu.service.SiteService;
import com.lu.util.ResultResponse;

@Controller
@RequestMapping("/site")
public class SiteController {

	@Autowired
	private SiteService siteService;
	
	@Autowired
	private MessageSource messageSource;

	
	@RequestMapping("/create")
	@ResponseBody
	public ResultResponse createSite(HttpServletRequest request,Site site){
		ResultResponse result = new ResultResponse();
		if(site!=null){
			if(!siteService.checkName(site.getName())){
				siteService.save(site);
				result.setMessage("Create Success");
			}else{
				result.setResult(Boolean.FALSE);
				result.setMessage("Failure! Name Exists");
			}
		}
		
		return result; 
	}
	
	@RequestMapping("/create/checkname")
	@ResponseBody
	public ResultResponse checkName(HttpServletRequest request){
		ResultResponse result = new ResultResponse();
		
		String name=request.getParameter("name").trim();
		if(name!=null){
			boolean flag=siteService.checkName(name);
			if(flag){
				result.setResult(Boolean.FALSE);
				result.setMessage("Name Exists!");
			}else{
				result.setMessage("Name Avaiable!");
			}
		}
		
		return result;
	}
	@RequestMapping(value = "fuzzy", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<ResultVO> fuzzy2(@RequestParam("q") String queryKey,@RequestParam("site") String site) {
		System.out.println(queryKey);
		return siteService.fuzzyQuerySite(queryKey.trim(),site.trim());
	}
	
}
