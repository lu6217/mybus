package com.lu.entity.train_site;

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
@Table(name = "tb_train_site")
@DynamicInsert
@DynamicUpdate
public class Train_Site{

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "train_id")
	private Long trainId;
	
	@Column(name="site_id")
	private Long siteId;
	
	@Column(name="price")
	private String price;
	
	@Column(name="leave_time")
	private Date departureTime;
	
	@Column(name="numberDay")
	private Long numberDay;
	
	@Column(name="arrival_time")
	private Date arrivalTime;
	
	@Column(name="distance")
	private String distance;
	
	@Column(name="prve_site_id")
	private Long prveSiteId;
	
	@Column(name="next_site_id")
	private Long nextSiteId;

	@Column(name="number")
	private Long number;
	
	@Column(name="is_delete")
	private Boolean isDelete=Boolean.FALSE;
	
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

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
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

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public Long getPrveSiteId() {
		return prveSiteId;
	}

	public void setPrveSiteId(Long prveSiteId) {
		this.prveSiteId = prveSiteId;
	}

	public Long getNextSiteId() {
		return nextSiteId;
	}

	public void setNextSiteId(Long nextSiteId) {
		this.nextSiteId = nextSiteId;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

}
