package com.lu.entity.schedule;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
@Entity
@Table(name="tb_schedule")
@DynamicInsert
@DynamicUpdate
public class Schedule {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="trainId")
	private Long trainId;
	
	@Column(name="direction")
	private String direction;//方向
	
	@Column(name="departureTime")
	private Date departureTime;
	
	@Column(name="numberDay")
	private Long numberDay;
	
	@Column(name="arrivalTime")
	private Date arrivalTime;
	
	@Column(name="miles")
	private Double miles;//距离
	
	@Column(name="price")
	private String price; //票价
	
	@Column(name="time")
	private Date time;//运行时长
	
	@Column(name="status")
	private Long status;
	
	@Column(name="seatNum")
	private Long seatNum;
	
	@Transient
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

	public Long getTrainId() {
		return trainId;
	}

	public void setTrainId(Long trainId) {
		this.trainId = trainId;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
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

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Double getMiles() {
		return miles;
	}

	public void setMiles(Double miles) {
		this.miles = miles;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<ScheduleSite> getSites() {
		return sites;
	}

	public void setSites(List<ScheduleSite> sites) {
		this.sites = sites;
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
	
}
