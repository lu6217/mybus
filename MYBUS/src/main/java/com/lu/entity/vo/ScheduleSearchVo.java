package com.lu.entity.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ScheduleSearchVo {

private String beginSite;//始发站
	
	private String endSite; //终点站
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date departureDate;//发车时间
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date backDate;//发车时间

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

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getBackDate() {
		return backDate;
	}

	public void setBackDate(Date backDate) {
		this.backDate = backDate;
	}
	
	
}
