package com.lu.entity.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TrainVo {
	
	private String number; //����
	
	private String beginSite;//ʼ��վ
	
	private String endSite; //�յ�վ
	//1910/01/01 08:00:00
	@DateTimeFormat(pattern = "HH:mm")
	private Date StartTime;//����ʱ��
	
	private String price; //ȫƱ��
	
	private String num; //��Ʊ  

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
