package com.lu.entity.train;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
	
	private String number; //车次
	
	private Long beginSite;//始发站
	
	private Long endSite; //终点站
	
	private Date StartTime;//发车时间
	
	private String price; //全票价
	
	private Long num; //余票
	
	@Transient
	private List<Site> sites; //所经的站点
	
	private String category; //车辆类型    T  K  Z  
	
	private Integer status=TrainStatus.ON.getStatus();// 0禁用   10正常使用 

	private Date createTime;//创建时间
	
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
