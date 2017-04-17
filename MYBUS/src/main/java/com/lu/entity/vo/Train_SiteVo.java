package com.lu.entity.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Train_SiteVo {

	private Long id;
	
	private Long trainId;
	
	private String trainNumber;
	
	private String site;
	
	private String price;

	@DateTimeFormat(pattern = "HH:mm")
	private Date departureTime;
	
	@DateTimeFormat(pattern = "HH:mm")
	private Date arrivalTime;
	
	private String distance;
	
	private String prevsite;
	
	private String nextSite;

	private Long siteNumber;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTrainId() {
		return trainId;
	}

	public void setTrainId(Long trainId) {
		this.trainId = trainId;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	public Long getSiteNumber() {
		return siteNumber;
	}

	public void setSiteNumber(Long siteNumber) {
		this.siteNumber = siteNumber;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getPrevsite() {
		return prevsite;
	}

	public void setPrevsite(String prevsite) {
		this.prevsite = prevsite;
	}

	public String getNextSite() {
		return nextSite;
	}

	public void setNextSite(String nextSite) {
		this.nextSite = nextSite;
	}
	
	
}
