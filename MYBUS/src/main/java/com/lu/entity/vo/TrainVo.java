package com.lu.entity.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TrainVo {
	
	private String number; //车次
	
	private String beginSite;//始发站
	
	private String endSite; //终点站
	//1910/01/01 08:00:00
	@DateTimeFormat(pattern = "HH:mm")
	private Date StartTime;//发车时间
	
	private String price; //全票价
	
	private String num; //余票  

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

	public Date getStartTime() {
		return StartTime;
	}

	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

}
