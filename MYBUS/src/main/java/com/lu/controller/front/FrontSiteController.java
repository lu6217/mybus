package com.lu.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.entity.vo.ResultVO;
import com.lu.service.SiteService;

@Controller
@RequestMapping("/front/site")
public class FrontSiteController {

	@Autowired
	private SiteService siteService;
	
	@RequestMapping(value = "fuzzy", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<ResultVO> fuzzy(@RequestParam("q") String queryKey,@RequestParam("site") String site) {
		return siteService.fuzzyQuerySite(queryKey.trim(),site.trim());
	}
}
