package com.lu.entity.vo.view;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.lu.entity.site.Site;
import com.lu.entity.train.TrainNumber;

public class ScheduleView {

	private Long id;
	
//	private String name;
	
	private Long trainId;
	
	private TrainNumber train;
	
//	private String direction;//方向
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date departureTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Long numberDay;
	
//	private Long beginSiteId;
	
	private Site beginSite;
	
//	private Long endSiteId;
	
	private Site endSite;
	
	private Date arrivalTime;
	
//	private Double miles;//距离
	
	private String price; //票价
	
	private Date time;//运行时长
	
	private Long status;
	
	private Long seatNum;

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

	public TrainNumber getTrain() {
		return train;
	}

	public void setTrain(TrainNumber train) {
		this.train = train;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Long getNumberDay() {
		return numberDay;
	}

	public void setNumberDay(Long numberDay) {
		this.numberDay = numberDay;
	}

	public Site getBeginSite() {
		return beginSite;
	}

	public void setBeginSite(Site beginSite) {
		this.beginSite = beginSite;
	}

	public Site getEndSite() {
		return endSite;
	}

	public void setEndSite(Site endSite) {
		this.endSite = endSite;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
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

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(Long seatNum) {
		this.seatNum = seatNum;
	}
	
//	private List<ScheduleSite> sites;
	
	
}
