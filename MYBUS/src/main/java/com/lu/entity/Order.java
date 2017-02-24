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

@Entity
@Table(name="ORDER")
@DynamicInsert
@DynamicUpdate
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToMany
	@JoinColumn
	private List<User> users;
	
	private Long account;
	
	private Long trainNumber;
	
	private Long beginSite;
	
	private Long endSite;
	
	private Long num;
	
	private Date startTime;
	
	private String category;
	
	private String seat;//座位
	
	private String price;  //用目的地的价格减去出发站的价格
	
	private String status;//待付款   已付款  已支付待乘车   已取消     已退订  已关闭   已完成
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Long getAccount() {
		return account;
	}

	public void setAccount(Long account) {
		this.account = account;
	}
	
	public Long getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(Long trainNumber) {
		this.trainNumber = trainNumber;
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

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
