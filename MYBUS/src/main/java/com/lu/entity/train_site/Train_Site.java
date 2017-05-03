package com.lu.entity.train_site;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.lu.entity.site.Site;
import com.lu.entity.train.TrainNumber;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "train_id", updatable = false, insertable = false)
	private TrainNumber train;
	
	@Column(name="site_id")
	private Long siteId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "site_id", updatable = false, insertable = false)
	private Site site;
	
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

	public TrainNumber getTrain() {
		return train;
	}

	public void setTrain(TrainNumber train) {
		this.train = train;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}
