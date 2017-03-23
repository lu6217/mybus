package com.lu.controller.train;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.entity.site.Site;
import com.lu.entity.train.TrainNumber;
import com.lu.entity.vo.TrainVo;
import com.lu.service.SiteService;
import com.lu.service.TrainService;
import com.lu.util.ResultResponse;

@Controller
@RequestMapping("/train")
public class TrainController {

	@Autowired
	private TrainService trainService;
	
	@Autowired
	private SiteService siteService;
	
	@RequestMapping("/create")
	@ResponseBody
	public ResultResponse addTrain(HttpServletRequest request,TrainVo trainVo){
		
		ResultResponse result = new ResultResponse();
		if(trainVo!=null){
			if(trainService.checkName(trainVo.getNumber().trim())){
				result.setResult(Boolean.FALSE);
				result.setMessage("failure! Name Exists" );
			}
			Site beginsite=siteService.getSiteByName(trainVo.getBeginSite());
			Site endsite=siteService.getSiteByName(trainVo.getEndSite());
			if(beginsite!=null && endsite!=null){
				TrainNumber train=new TrainNumber();
				train.setNumber(trainVo.getNumber().trim());
				train.setBeginSite(beginsite.getId());
				train.setEndSite(endsite.getId());
				train.setNum(Long.parseLong(trainVo.getNum().trim()));
				train.setPrice(trainVo.getPrice().trim());
				train.setStartTime(trainVo.getStartTime());
				train.setCreateTime(new Date());
				trainService.save(train);
				result.setMessage("Success!");
			}else{
				result.setResult(Boolean.FALSE);
				result.setMessage("failure! Site Error");
			}
		}else{
			result.setResult(Boolean.FALSE);
			result.setMessage("failure!");
		}
		return result;
	}
	
	@RequestMapping("/create/checkname")
	@ResponseBody
	public ResultResponse checkName(HttpServletRequest request){
		ResultResponse result = new ResultResponse();
		String name=request.getParameter("name").trim();
		if(name!=null){
			boolean flag=trainService.checkName(name);
			if(flag){
				result.setResult(Boolean.FALSE);
				result.setMessage("Name Exists!");
			}else{
				result.setMessage("Name Avaiable!");
			}
		}
		
		return result;
	}
}
