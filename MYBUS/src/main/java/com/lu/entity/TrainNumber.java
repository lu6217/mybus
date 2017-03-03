package com.lu.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.lu.entity.enumType.TrainStatus;
@Entity
@Table(name="tb_train")
@DynamicInsert
@DynamicUpdate
public class TrainNumber {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String number; //车次
	
	private Long beginSite;//始发站
	
	private Long endSite; //终点站
	
	private Date StartTime;//发车时间
	
	private String price; //票价
	
	private Long num; //余票
	
	@OneToMany
	@JoinColumn
	private List<Site> sites;
	
	private String category;
	
	private Integer status=TrainStatus.ON.getStatus();// 0禁用   10正常使用 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getBeginSite() {
		return beginSite;
	}

	public void setBeginSite(Long beginSite) {
		this.beginSite = beginSite;
	}

	public Long getEndSite() {
		return endSite;
	}

	public void setEndSite(Long endSite) {
		this.endSite = endSite;
	}

	public List<Site> getSites() {
		return sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
