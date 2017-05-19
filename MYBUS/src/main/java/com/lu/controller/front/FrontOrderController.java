package com.lu.controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lu.entity.order.Order;
import com.lu.service.OrderService;
@Controller
@RequestMapping("/front/order")
public class FrontOrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/qrcode/getorderinfo/{id}")
	public String getqrcodeInfo(@PathVariable("id")Long id, Model model){
		//
		Order order=orderService.getOrderById(id);
		order.setQrcodeStatus(1L);
		orderService.saveOrUpdateOrder(order);
		//设置了状态后 应该要发短息给用户   现在还没有完成
		model.addAttribute("order", order);
		return "/view/front/order/qrcodeinfo";
	}
}
