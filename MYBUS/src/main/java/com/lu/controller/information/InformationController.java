package com.lu.controller.information;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.controller.home.MenuUtil;
import com.lu.entity.common.Information;
import com.lu.entity.vo.InformationVo;
import com.lu.service.InformationService;
import com.lu.util.PagingVO;
import com.lu.util.ResultResponse;

@Controller
@RequestMapping("/information")
public class InformationController {
	
	@Autowired
	private InformationService informationService;
	
	@RequestMapping("/informationlist")
	public String informationSearchList(PagingVO pagingVo,InformationVo informationVo,Model model, HttpServletRequest request){
		PagingVO vo =informationService.searchList(pagingVo,informationVo);
		model.addAttribute("pageVO", vo);
		model.addAttribute("menus", MenuUtil.getMenus(request));
		return "view/background/information/informationlist";
	}
	
	@RequestMapping("/toaddinformation/{id}")
	public String toAddinformation(@PathVariable("id")Long id, Model model){
//		model.addAttribute("accountId", id);
		return "view/background/information/addinformation";
	}
	
	@RequestMapping("/addinformation")
	@ResponseBody
	public ResultResponse addInformation(HttpServletRequest request,Information information){
		ResultResponse result = new ResultResponse();
		if(information!=null){
			information.setIsDelete(Boolean.FALSE);
			information.setCreateDate(new Date());
			if(informationService.saveOrUpdate(information)){
				result.setMessage("Success!");
				return result;
			}else {
				result.setResult(Boolean.FALSE);
				result.setMessage("failure!");
			}
		}
		return result;
	}
	
	@RequestMapping("/get/{id}")
	public String getTrain(@PathVariable("id")Long id, Model model){
		Information information=informationService.getInformationById(id);
		model.addAttribute("information", information);
		return "view/background/information/addinformation";
	}
	
	@RequestMapping("/delinformation")
	@ResponseBody
	public ResultResponse delTrain(HttpServletRequest request){
		ResultResponse result = new ResultResponse();
		Long id=Long.parseLong(request.getParameter("id").trim());
		Information information=informationService.getInformationById(id);
		if(information!=null){
			information.setIsDelete(Boolean.TRUE);
			informationService.saveOrUpdate(information);
			result.setMessage("OK! 删除成功!");
		}else{
			result.setResult(Boolean.FALSE);
			result.setMessage("falure!");
		}
		return result;
	}
	
}
