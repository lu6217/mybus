package com.lu.controller.order;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import com.lu.entity.account.Account;
import com.lu.entity.account.User;
import com.lu.entity.vo.view.ScheduleView;
import com.lu.service.AccountService;
import com.lu.service.SiteService;
import com.lu.service.TrainService;
import com.lu.service.UserService;


@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private TrainService trainService;
	
	@Autowired
	private SiteService siteService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/initorder")
	public String initOrder(HttpServletRequest request, Model model,HttpServletResponse response) throws IOException{
		ScheduleView scheduleview=new ScheduleView();
		Account account = (Account)WebUtils.getSessionAttribute(request, "account");
		scheduleview.setId(Long.parseLong(request.getParameter("id").trim()));
		Long trainId=Long.parseLong(request.getParameter("id").trim());
		scheduleview.setTrain(trainService.getTrainById(trainId));
		
		Long beginSiteId=Long.parseLong(request.getParameter("beginSiteId").trim());
		Long endSiteId=Long.parseLong(request.getParameter("endSiteId").trim());
		scheduleview.setBeginSite(siteService.getSiteById(beginSiteId));
		scheduleview.setEndSite(siteService.getSiteById(endSiteId));
		try {
			scheduleview.setDepartureTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("departureTime").trim()));
			scheduleview.setArrivalTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("arrivalTime").trim()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scheduleview.setNumberDay(Long.parseLong(request.getParameter("numberDay").trim()));
		scheduleview.setPrice(request.getParameter("price").trim());
		Long accountId=account.getId();
		List<User> userLists=userService.getUserByAccountId(accountId);
		
		model.addAttribute("scheduleView", scheduleview);
		model.addAttribute("users", userLists);
		
//		response.sendRedirect(request.getContextPath() + "/view/front/initorder.jsp");
		return "/view/front/initorder";
	}
}
