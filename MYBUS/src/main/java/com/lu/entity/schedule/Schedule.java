package com.lu.entity.schedule;

import java.util.Date;
import java.util.List;

public class Schedule {

	private Long id;
	
	private String name;
	
	private Long lineId;
	
	private String direction;//方向
	
	private Date startTime;
	
	private Date endTime;
	
	private Double miles;//距离
	
	private Double price; //价格
	
	private List<ScheduleSite> sites;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getLineId() {
		return lineId;
	}

	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Double getMiles() {
		return miles;
	}

	public void setMiles(Double miles) {
		this.miles = miles;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<ScheduleSite> getSites() {
		return sites;
	}

	public void setSites(List<ScheduleSite> sites) {
		this.sites = sites;
	}
	
}
