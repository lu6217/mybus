package com.lu.entity.order;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.lu.entity.account.User;
import com.lu.entity.enumType.OrderStatus;
import com.lu.entity.seat.Seat;
import com.lu.entity.site.Site;
import com.lu.entity.train.TrainNumber;


@Entity
@Table(name="tb_order")
@DynamicInsert
@DynamicUpdate
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="account_Id")
	private Long accountId;
	
	@Column(name = "user_Id")
	private Long userId;//userId
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_Id", updatable = false, insertable = false)
	private User user;
	
	@Column(name="train_Id")
	private Long trainId; //车次Id
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "train_Id", updatable = false, insertable = false)
	private TrainNumber train;
	
	@Column(name="beginSite_Id")
	private Long beginSiteId; //乘车站
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beginSite_Id", updatable = false, insertable = false)
	private Site beginSite;
	
	@Column(name="endSite_id")
	private Long endSiteId; //目的站
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endSite_id", updatable = false, insertable = false)
	private Site endSite;
	
	@Column(name="departureTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date departureTime; //发车时间
	
	@Column(name="arrivalTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date arrivalTime;//到达时间
	
	@Column(name="seatType")
	private Integer seatType;  //座位类型
	
	@Column(name="seatId")
	private Long seatId;//座位
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "seatId", updatable = false, insertable = false)
	private Seat seat;
	
	@Column(name="price")
	private String price;  //票价  目的站点的票价减去乘车站点的票价
	
	@Column(name="status")
	private String status=OrderStatus.OrderStatus_ToPay.getDescription();//未支付   已支付未乘车  已支付已乘车  已结束   退订  改签 

	@Column(name="createTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	
	@Column(name="qrcodeImg")
	private String qrcodeImg;
	
	@Column(name="qrcodeStatus")
	private Long qrcodeStatus;  // 0 未生成   1 已生成未检票  2 已检票
	
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


	public Integer getSeatType() {
		return seatType;
	}

	public void setSeatType(Integer seatType) {
		this.seatType = seatType;
	}

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TrainNumber getTrain() {
		return train;
	}

	public void setTrain(TrainNumber train) {
		this.train = train;
	}

	public Site getBeginSite() {
		return beginSite;
	}

	public void setBeginSite(Site beginSite) {
		this.beginSite = beginSite;
	}

	public Site getEndSite() {
		return endSite;
	}

	public void setEndSite(Site endSite) {
		this.endSite = endSite;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public String getQrcodeImg() {
		return qrcodeImg;
	}

	public void setQrcodeImg(String qrcodeImg) {
		this.qrcodeImg = qrcodeImg;
	}

	public Long getQrcodeStatus() {
		return qrcodeStatus;
	}

	public void setQrcodeStatus(Long qrcodeStatus) {
		this.qrcodeStatus = qrcodeStatus;
	}
	
}
