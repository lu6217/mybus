package com.lu.entity.train;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.lu.entity.enumType.TrainStatus;
import com.lu.entity.site.Site;
@Entity
@Table(name="tb_train")
@DynamicInsert
@DynamicUpdate
public class TrainNumber {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="name")
	private String number; //车次
	
	@Column(name="beginSite_id")
	private Long beginSiteId;//始发站
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beginSite_id", updatable = false, insertable = false)
	private Site beginSite;
	
	@Column(name="endSite_id")
	private Long endSiteId; //终点站
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endSite_id", updatable = false, insertable = false)
	private Site endSite;
	
	@Column(name="startTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date departureTime;//发车时间
	
	@Column(name="numberDay")
	private Long numberDay;
	
	@Column(name="arrivalTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date arrivalTime;//到达时间
	
	@Column(name="price")
	private String price; //全票价
	
	@Column(name="num")
	private Long num; //余票
	
	@Column(name="time")
	private Date time;//运行时长
	
	@Transient
	private long hour;
	
	@Transient
	private long minute;
	
	@Transient
	private List<Site> sites; //所经的站点
	
	@Column(name="category")
	private String category; //车辆类型    T  K  Z  
	
	@Column(name="status")
	private Integer status=TrainStatus.ON.getStatus();// 0禁用   10正常使用 
	
	@Column(name="createTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;//创建时间
	
	@Column(name="is_delete")
	private Boolean isDelete=Boolean.FALSE;
	
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

	public Long getBeginSiteId() {
		return beginSiteId;
	}

	public void setBeginSiteId(Long beginSiteId) {
		this.beginSiteId = beginSiteId;
	}

	public Site getBeginSite() {
		return beginSite;
	}

	public void setBeginSite(Site beginSite) {
		this.beginSite = beginSite;
	}

	public Long getEndSiteId() {
		return endSiteId;
	}

	public void setEndSiteId(Long endSiteId) {
		this.endSiteId = endSiteId;
	}

	public Site getEndSite() {
		return endSite;
	}

	public void setEndSite(Site endSite) {
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public long getHour() {
		return hour;
	}

	public void setHour(long hour) {
		this.hour = hour;
	}

	public long getMinute() {
		return minute;
	}

	public void setMinute(long minute) {
		this.minute = minute;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

}
