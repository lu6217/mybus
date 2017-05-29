package com.lu.controller.order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.lu.controller.home.MenuUtil;
import com.lu.entity.account.Account;
import com.lu.entity.account.User;
import com.lu.entity.enumType.OrderStatus;
import com.lu.entity.order.Order;
import com.lu.entity.vo.OrderSearchVo;
import com.lu.entity.vo.OrderVo;
import com.lu.entity.vo.view.ScheduleView;
import com.lu.service.AccountService;
import com.lu.service.AuthorityService;
import com.lu.service.OrderService;
import com.lu.service.ScheduleService;
import com.lu.service.ScheduleSiteService;
import com.lu.service.SeatService;
import com.lu.service.SiteService;
import com.lu.service.TrainService;
import com.lu.service.UserService;
import com.lu.util.BaseController;
import com.lu.util.PagingVO;
import com.lu.util.ResultResponse;


@Controller
@RequestMapping("/order")
public class OrderController extends BaseController{

	@Autowired
	private TrainService trainService;
	
	@Autowired
	private SiteService siteService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SeatService seatService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private ScheduleSiteService scheduleSiteService;
	
	@RequestMapping("/initorder/{id}/{trainId}/{beginSiteId}/{endSiteId}/{departureTime}/{arrivalTime}/{numberDay}/{price}")
	public String initOrder(@PathVariable("id")Long id,@PathVariable("trainId")Long trainId,
			@PathVariable("beginSiteId")Long beginSiteId,@PathVariable("endSiteId")Long endSiteId,
			@PathVariable("departureTime")String departureTime,@PathVariable("arrivalTime")String arrivalTime,
			@PathVariable("numberDay")Long numberDay,@PathVariable("price")String price
			,HttpServletRequest request, Model model,HttpServletResponse response){
		
		ScheduleView scheduleview=new ScheduleView();
		Account account = (Account)WebUtils.getSessionAttribute(request, "account");
		scheduleview.setId(id);
		scheduleview.setTrain(trainService.getTrainById(trainId));
		scheduleview.setBeginSite(siteService.getSiteById(beginSiteId));
		scheduleview.setEndSite(siteService.getSiteById(endSiteId));
		try {
			scheduleview.setDepartureTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(departureTime));
			scheduleview.setArrivalTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(arrivalTime));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scheduleview.setNumberDay(numberDay);
		scheduleview.setPrice(price);
		Long accountId=account.getId();
		List<User> userLists=userService.getUserByAccountId(accountId);
		
		model.addAttribute("scheduleView", scheduleview);
		model.addAttribute("users", userLists);
		model.addAttribute("menus", MenuUtil.getMenus(request));
		
		return "/view/front/initorder";
	}
	@RequestMapping("/getuserinfo")
	public String getUserInfo(HttpServletRequest request, Model model,HttpServletResponse response){
		String [] userlists=request.getParameterValues("userList");
		for(int i=0;i<userlists.length;i++){
			System.out.println(userlists[i]);
		}
		return "";
	}
	
	@RequestMapping("/createorder")
	@ResponseBody
	public ResultResponse createOrder(HttpServletRequest request,OrderVo orderVo){
		
		ResultResponse result = new ResultResponse();
		Long accountId= ((Account)WebUtils.getSessionAttribute(request, "account")).getId();
		//生成订单
		//在userlists 中一个一个取出Id   每个用户生成一个order   
		if(orderVo.getUserLists()!=null && orderVo.getUserLists().length>0){
			
			for(int i=0;i<orderVo.getUserLists().length;i++){
				Order order=new Order();
				order.setUserId(orderVo.getUserLists()[i]);
				if(orderService.getOrderByUserIdAndTrainId(orderVo.getUserLists()[i],orderVo.getTrainId(),orderVo.getDepartureTime())!=null){
					result.setMessage("用户订单和已有订单冲突！");
					result.setResult(Boolean.FALSE);
					return result;
				}
				order.setAccountId(accountId);
				order.setDepartureTime(orderVo.getDepartureTime());
				order.setArrivalTime(orderVo.getArrivalTime());
				order.setBeginSiteId(orderVo.getBeginSiteId());
				order.setEndSiteId(orderVo.getEndSiteId());
				order.setPrice(orderVo.getPrice());
				order.setTrainId(orderVo.getTrainId());
				order.setCreateTime(new Date());
				if(!orderService.saveOrUpdateOrder(order,orderVo)){
					result.setResult(Boolean.FALSE);
					result.setMessage("failure!");
					return result;
				}
//				Long scheduleId=scheduleSiteService.getScheduleId(orderVo.getTrainId(),orderVo.getBeginSiteId(),orderVo.getDepartureTime());
//				Schedule schedule=scheduleService.getScheduleById(scheduleId);
//				schedule.setSeatNum(schedule.getSeatNum()-1);
//				scheduleService.updateSchedule(schedule);
//				//设置座位  
//				Seat seat=seatService.getOneSeat(orderVo.getTrainId());
//				seat.setStatus(1L);
//				seatService.saveOrUpdateSeat(seat);
//				order.setSeatId(seat.getId());
//				orderService.saveOrUpdateOrder(order);
				
//				order=orderService.getOrderByUserIdAndTrainId(orderVo.getUserLists()[i],orderVo.getTrainId(),orderVo.getDepartureTime());
//				result.addAttribute("order"+i, order);
			}
			result.setMessage("success!");
		}else{
			result.setResult(Boolean.FALSE);
			result.setMessage("failure!");
		}
		
		return result;
	}
	
	
	@RequestMapping("/orderlist")
	public String orderlist(PagingVO pagingVo,OrderSearchVo orderSearchVo,Model model, HttpServletRequest request){
//		Long accountId= ((Account)WebUtils.getSessionAttribute(request, "account")).getId();
		PagingVO vo =orderService.searchList(pagingVo,orderSearchVo);
		model.addAttribute("pageVO", vo);
		model.addAttribute("menus", MenuUtil.getMenus(request));
		return "/view/front/orderlist";
	}
	
	@RequestMapping("/accountorderlist")
	public String accountOrderlist(PagingVO pagingVo,OrderSearchVo orderSearchVo,Model model, HttpServletRequest request){
		Long accountId= ((Account)WebUtils.getSessionAttribute(request, "account")).getId();
		PagingVO vo =orderService.searchList(pagingVo,orderSearchVo,accountId);
		model.addAttribute("pageVO", vo);
		model.addAttribute("menus", MenuUtil.getMenus(request));
		return "/view/front/accountorderlist";
	}
	
	
	@RequestMapping("/delorder")
	@ResponseBody
	public ResultResponse delOrder(HttpServletRequest request){
		ResultResponse result = new ResultResponse();
		Long id=Long.parseLong(request.getParameter("id").trim());
		if(id!=null){
			Order order=orderService.getOrderById(id);
			if(order!=null){
			order.setStatus(OrderStatus.OrderStatus_Canceled.getDescription());
			orderService.saveOrUpdateOrder(order);
			result.setMessage("success!");
			}
		}else{
			result.setMessage("failure");
			result.setResult(Boolean.FALSE);
			return result;
		}
		return result;
	}
	
	
	@RequestMapping("/getorderinfo/{id}")
	public String getOrderInfo(@PathVariable("id")Long id, Model model){
		Order order=orderService.getOrderById(id);
		model.addAttribute("order", order);
		return "/view/front/order/orderinfo";
	}
	
	@RequestMapping("/qrcode/getorderinfo/{id}")
	public String getqrcodeInfo(@PathVariable("id")Long id, Model model){
		Order order=orderService.getOrderById(id);
		model.addAttribute("order", order);
		return "/view/front/order/qrcodeinfo";
	}
	
	
	@RequestMapping("/topay")
	@ResponseBody
	public ResultResponse toPay(HttpServletRequest request, Model model){
		ResultResponse result = new ResultResponse();
		//可以通过userid 和trainID来确定orderID   然后将status修改  
		Long id=Long.parseLong(request.getParameter("id").trim());
		Order order=orderService.getOrderById(id);
		if(order!=null){
			order.setStatus(OrderStatus.OrderStatus_Paied.getDescription());
			orderService.saveOrUpdateOrder(order);
			result.setMessage("支付成功！");
		}else{
			result.setMessage("支付失败");
			result.setResult(Boolean.FALSE);
			
		}
		return result;
	}
	@RequestMapping("/createqrcode/{id}")
	public String createQrcode(@PathVariable("id")Long id,Model model, HttpServletRequest request){
//		Long id=Long.parseLong(request.getParameter("id").trim());
		Order order=orderService.getOrderById(id);
		//生成二维码
//		String path=request.getContextPath()+"/images/qrcodeImages/";
//		String path="E:/myBusGit/mybus/MYBUS/src/main/webapp/images/qrcodeImages/";
		String path=request.getSession().getServletContext().getRealPath("/images/qrcodeImages")+"/";
		orderService.createQrcode(order,path);
		
		order=orderService.getOrderById(id);
		model.addAttribute("order", order);
		return "/view/front/order/qrcodeview";
	}
	
	@RequestMapping("/showqrcode/{id}")
	public String showqrcodeInfo(@PathVariable("id")Long id, Model model,HttpServletRequest request){
		Order order=orderService.getOrderById(id);
		model.addAttribute("order", order);
		return "/view/front/order/qrcodeview";
	}
//	@RequestMapping("/createqrcode")
//	public RestResponse createQrcode(Model model, HttpServletRequest request){
//		return processSimple(new RestResponse(), new Taker() {
//			@Override
//			public void process(RestResponse rr) {
//				Long id=Long.parseLong(request.getParameter("id").trim());
//				
//				try {
//						
//						rr.addAttribute("grade","image");
//					} catch (Exception e) {
//						rr.setResult(false);
//						rr.setMessage(e.getMessage());
//						e.printStackTrace();
////						PssLogFactory.getErrorLog().error(CourseWishController.class.getSimpleName(), e);
//					}
//					return;
//				}
//		});
//	}
//	
}
