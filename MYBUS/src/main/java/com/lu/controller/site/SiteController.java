package com.lu.controller.site;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.controller.home.MenuUtil;
import com.lu.entity.site.Site;
import com.lu.entity.vo.ResultVO;
import com.lu.entity.vo.UserVo;
import com.lu.service.AuthorityService;
import com.lu.service.SiteService;
import com.lu.util.PagingVO;
import com.lu.util.ResultResponse;

@Controller
@RequestMapping("/site")
public class SiteController {

	@Autowired
	private SiteService siteService;
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private AuthorityService authorityService;
	
	@RequestMapping("/tocreatesite/{id}")
	public String toAddTrainSite(@PathVariable("id")Long id, Model model){
//		model.addAttribute("accountId", id);
		return "view/background/site/createsite";
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public ResultResponse createSite(HttpServletRequest request,Site site){
		ResultResponse result = new ResultResponse();
		if(site!=null){
			site.setIsDelete(Boolean.FALSE);
			if(site.getId()!=null){
				siteService.saveOrUpdate(site);
				result.setMessage("Success");
			}else{
				if(!siteService.checkName(site.getName())){
						siteService.saveOrUpdate(site);
						result.setMessage("Success");
				}else{
					result.setResult(Boolean.FALSE);
					result.setMessage("Failure! Name Exists");
				}
			}
		}
		return result; 
	}
	
	@RequestMapping("/get/{id}")
	public String getTrain(@PathVariable("id")Long id, Model model){
		Site site=siteService.getSiteById(id);
		model.addAttribute("site", site);
		return "view/background/site/createsite";
	}
	
	@RequestMapping("/delsite")
	@ResponseBody
	public ResultResponse delTrain(HttpServletRequest request){
		ResultResponse result = new ResultResponse();
		Long id=Long.parseLong(request.getParameter("id").trim());
		Site site=siteService.getSiteById(id);
		if(site!=null){
			site.setIsDelete(Boolean.TRUE);
			siteService.saveOrUpdate(site);
			result.setMessage("OK! 删除成功!");
		}else{
			result.setResult(Boolean.FALSE);
			result.setMessage("falure!");
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
	public List<ResultVO> fuzzy(@RequestParam("q") String queryKey,@RequestParam("site") String site) {
		return siteService.fuzzyQuerySite(queryKey.trim(),site.trim());
	}
	
	@RequestMapping(value = "fuzzy2", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<ResultVO> fuzzy2(@RequestParam("q") String queryKey,@RequestParam("trainId") Long trainId
			,@RequestParam("pr") Long pr) {
		return siteService.fuzzyQuerySite2(queryKey.trim(),trainId,pr);
	}
	
	
	@RequestMapping("/sitelist")
	public String siteSearchList(PagingVO pagingVo,UserVo userVo,Model model, HttpServletRequest request){
		PagingVO vo =siteService.searchAllSiteList(pagingVo);
		model.addAttribute("pageVO", vo);
		model.addAttribute("menus", MenuUtil.getMenus(request));
		return "view/background/site/sitelist";
	}
}
