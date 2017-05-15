package com.lu.service;

import java.util.Date;

import com.lu.entity.order.Order;
import com.lu.entity.vo.OrderSearchVo;
import com.lu.util.PagingVO;

public interface OrderService {

	void saveOrUpdateOrder(Order order);

	PagingVO searchList(PagingVO pagingVo, OrderSearchVo orderSearchVo, Long accountId);

	Order getOrderByUserIdAndTrainId(Long userId, Long trainId, Date date);

	Order getOrderById(Long id);

	void createQrcode(Order order, String path);

}
