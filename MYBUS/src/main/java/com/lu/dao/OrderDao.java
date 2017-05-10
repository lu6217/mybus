package com.lu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lu.entity.order.Order;
import com.lu.entity.vo.OrderSearchVo;
import com.lu.util.BaseDAO;
import com.lu.util.DetachedCriteriaBuilder;
import com.lu.util.PagingVO;

@Repository
public class OrderDao extends BaseDAO<Order>{

	public PagingVO searchList(PagingVO pagingVo, OrderSearchVo orderSearchVo, Long accountId) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = initQueryCriteria(orderSearchVo,accountId);
		DetachedCriteriaBuilder count = initQueryCriteria(orderSearchVo,accountId);
		return this.selectPagingVO(query, pagingVo, count);
	}

	private DetachedCriteriaBuilder initQueryCriteria(OrderSearchVo orderSearchVo, Long accountId) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = DetachedCriteriaBuilder.instance(Order.class, "order");
		query.leftJoin("order.train", "train").leftJoin("order.user", "user")
		.leftJoin("order.beginSite", "beginSite").leftJoin("order.endSite", "endSite").leftJoin("order.seat", "seat");
//		query.addEq("order.accountId", accountId);
		return query;
	}

	public Order getOrderByUserIdAndTrainId(Long userId, Long trainId) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = DetachedCriteriaBuilder.instance(Order.class, "order");
		query.leftJoin("order.train", "train").leftJoin("order.user", "user")
		.leftJoin("order.beginSite", "beginSite").leftJoin("order.endSite", "endSite").leftJoin("order.seat", "seat");
		query.addEq("order.userId", userId).addEq("order.trainId", trainId);
		return this.selectTopOne(query);
	}

	public Order getOrderById(Long id) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = DetachedCriteriaBuilder.instance(Order.class, "order");
		query.leftJoin("order.train", "train").leftJoin("order.user", "user")
		.leftJoin("order.beginSite", "beginSite").leftJoin("order.endSite", "endSite").leftJoin("order.seat", "seat");
		query.addEq("id", id);
		return this.selectTopOne(query);
	}

	public List<Order> getOrderByUserId(Long userId) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = DetachedCriteriaBuilder.instance(Order.class, "order");
		query.addEq("userId", userId);
		return select(query);
	}

	public List<Order> getOrderByTrainId(Long trainId) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = DetachedCriteriaBuilder.instance(Order.class, "order");
		query.addEq("trainId", trainId);
		return select(query);
	}
	
}
