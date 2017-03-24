package com.lu.entity.order;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
@Entity
@Table(name="tb_order_item")
@DynamicInsert
@DynamicUpdate
public class OrderItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "user_Id")
	private Long userId;//用户Id
	
	@Column(name="train_Id")
	private Long trainId; //车次Id
	
	@Column(name="beginSite_Id")
	private Long beginSiteId; //乘车站
	
	@Column(name="endSite_id")
	private Long endSiteId; //下车站
	
	@Column(name="startTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime; //发车时间
	
	@Column(name="seatType")
	private Integer seatType;  //席别
	
	@Column(name="seat")
	private String seat;//座位
	
	@Column(name="price")
	private String price;  //用目的地的价格减去出发站的价格的绝对值
	
	@Column(name="status")
	private String status;//待付款   已付款  已支付待乘车   已取消     已退订  已关闭   已完成

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTrainId() {
		return trainId;
	}

	public void setTrainId(Long trainId) {
		this.trainId = trainId;
	}

	public Long getBeginSiteId() {
		return beginSiteId;
	}

	public void setBeginSiteId(Long beginSiteId) {
		this.beginSiteId = beginSiteId;
	}

	public Long getEndSiteId() {
		return endSiteId;
	}

	public void setEndSiteId(Long endSiteId) {
		this.endSiteId = endSiteId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Integer getSeatType() {
		return seatType;
	}

	public void setSeatType(Integer seatType) {
		this.seatType = seatType;
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
