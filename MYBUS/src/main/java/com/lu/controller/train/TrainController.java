package com.lu.controller.train;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.entity.site.Site;
import com.lu.entity.train.TrainNumber;
import com.lu.entity.train_site.Train_Site;
import com.lu.entity.vo.TrainSearchVo;
import com.lu.entity.vo.TrainVo;
import com.lu.service.SiteService;
import com.lu.service.TrainService;
import com.lu.service.Train_SiteService;
import com.lu.util.PagingVO;
import com.lu.util.ResultResponse;

@Controller
@RequestMapping("/train")
public class TrainController {

	@Autowired
	private TrainService trainService;
	
	@Autowired
	private SiteService siteService;
	
	@Autowired
	private Train_SiteService train_siteService;
	
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
				train.setDepartureTime(trainVo.getDepartureTime());
				train.setArrivalTime(trainVo.getArrivalTime());
				train.setCreateTime(new Date());
				trainService.save(train);
				train=trainService.getTrainByName(trainVo.getNumber().trim());
				saveBeginSite(beginsite,endsite,trainVo,train);
				saveEndSite(beginsite,endsite,trainVo,train);
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
	
	public void saveBeginSite(Site beginsite,Site endsite,TrainVo trainVo, TrainNumber train){
		Train_Site train_Site=new Train_Site();
		//保存 车站id  前一站id  后一站id   trainId 等信息 
		//保存了train后要保存两个站点  始发站和终点站   始发站的price为0    终点站的price为全票价
		//设置始发站的前一站的id为0   终点站的下一站的id为-1
		train_Site.setPrveSiteId(0L);
		train_Site.setSiteId(beginsite.getId());
		train_Site.setNextSiteId(endsite.getId());
		train_Site.setTrainId(train.getId());
//		//现在发车时间和到达时间还没有   有待添加 
		//始发站应该没有到达时间
		//train_Site.setArrivalTime(trainVo.getArrivalTime());
		train_Site.setDepartureTime(trainVo.getDepartureTime());
		train_Site.setPrice(trainVo.getPrice());
//		//还要建train_site的server和dao  并且保存train_site
		train_siteService.save(train_Site);
	}
	
	public void saveEndSite(Site beginsite,Site endsite,TrainVo trainVo, TrainNumber train){
		Train_Site train_Site=new Train_Site();
		
		train_Site.setPrveSiteId(beginsite.getId());
		train_Site.setSiteId(endsite.getId());
		train_Site.setNextSiteId(-1L);
		train_Site.setTrainId(train.getId());
//		//现在发车时间和到达时间还没有   有待添加 
		//终点站应该没有离开时间
		train_Site.setArrivalTime(trainVo.getArrivalTime());
//		train_Site.setDepartureTime(trainVo.getDepartureTime());
		train_Site.setPrice(trainVo.getPrice());
//		//还要建train_site的server和dao  并且保存train_site
		train_siteService.save(train_Site);
		
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
	
	@RequestMapping("/toaddtrain/{id}")
	public String toAdduser(@PathVariable("id")Long id, Model model){
		model.addAttribute("accountId", id);
		return "view/background/train/addtrain";
	}
	
	
	@RequestMapping("/trainlist")
	public String accountSearchList(PagingVO pagingVo,TrainSearchVo trainSearchVo,Model model, HttpServletRequest request){
		PagingVO vo =trainService.searchList(pagingVo,trainSearchVo);
		model.addAttribute("pageVO", vo);
		return "view/background/train/trainlist";
	}
	
	@RequestMapping("/get/{id}")
	public String getUser(@PathVariable("id")Long id, Model model){
		TrainNumber train=trainService.getTrainById(id);
		model.addAttribute("train", train);
		return "view/background/train/addtrain";
	}
}
