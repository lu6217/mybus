package com.lu.entity.order;

import java.util.Date;

//@Entity
//@Table(name="tb_order_item")
//@DynamicInsert
//@DynamicUpdate
public class OrderItem {
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
//	@Column(name="account_Id")
	private Long accountId;
	
//	@Column(name = "user_Id")
	private Long userId;//userId
	
//	@Column(name="train_Id")
	private Long trainId; //车次Id
	
//	@Column(name="beginSite_Id")
	private Long beginSiteId; //乘车站
	
//	@Column(name="endSite_id")
	private Long endSiteId; //目的站
	
//	@Column(name="startTime")
//	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime; //发车时间
	
//	@Column(name="seatType")
	private Integer seatType;  //座位类型
	
//	@Column(name="seat")
	private String seat;//座位
	
//	@Column(name="price")
	private String price;  //票价  目的站点的票价减去乘车站点的票价
	
//	@Column(name="status")
	private String status;//未支付   已支付未乘车  已支付已乘车  已结束   退订  改签 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
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
