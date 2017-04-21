package com.lu.entity.schedule;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
@Entity
@Table(name="tb_schedule_site")
@DynamicInsert
@DynamicUpdate
public class ScheduleSite {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
//	@Column(name="time")
//	private Date time;
	
	@Column(name="siteId")
	private Long siteId;
	
//	@Column(name="trainId")
//	private Long trainId;
	
	@Column(name="scheduleId")
	private Long scheduleId;
	
	@Column(name="departureTime")
	private Date departureTime;
	
	@Column(name="arrivalTime")
	private Date arrivalTime;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private String price;
	
	@Column(name="status")
	private Long status;

	@Column(name="seatNum")
	private Long seatNum;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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
