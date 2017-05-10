package com.lu.entity.vo;

import java.util.Date;

public class OrderVo {
	private Long id;
	
	private Long scheduleId;
	
	private Long trainId;
	
	private Long beginSiteId;//始发站
	
	private Long endSiteId; //终点站
	
	private Date departureTime;
	
	private Date arrivalTime;
	
	private Long numberDay;
	
	private Long[] userLists;
	
	private String price; //票价
	
	private Date time;//运行时长

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Long getTrainId() {
		return trainId;
	}

	public void setTrainId(Long trainId) {
		this.trainId = trainId;
	}

	public Long getBeginSiteId() {
		return beginSiteId;
	}

	public void setBeginSiteId(Long beginSiteId) {
		this.beginSiteId = beginSiteId;
	}

	public Long getEndSiteId() {
		return endSiteId;
	}

	public void setEndSiteId(Long endSiteId) {
		this.endSiteId = endSiteId;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Long getNumberDay() {
		return numberDay;
	}

	public void setNumberDay(Long numberDay) {
		this.numberDay = numberDay;
	}

	public Long[] getUserLists() {
		return userLists;
	}

	public void setUserLists(Long[] userLists) {
		this.userLists = userLists;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
