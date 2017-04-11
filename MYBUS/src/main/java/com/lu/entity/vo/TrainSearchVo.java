package com.lu.entity.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TrainSearchVo {

	private String number; //车次
	
	private String beginSite;//始发站
	
	private String endSite; //终点站
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date departureTime;//发车时间
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBeginSite() {
		return beginSite;
	}

	public void setBeginSite(String beginSite) {
		this.beginSite = beginSite;
	}

	public String getEndSite() {
		return endSite;
	}

	public void setEndSite(String endSite) {
		this.endSite = endSite;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	
}
