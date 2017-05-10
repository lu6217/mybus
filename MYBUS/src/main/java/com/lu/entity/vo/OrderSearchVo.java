package com.lu.entity.vo;

import java.util.Date;

public class OrderSearchVo {

	private Long id;
	
	private String trainNumber;
	
	private String userName;
	
	private Date departureTime;//发车日期  应该是个时间段   可以用两个字段来表示  

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	
}
