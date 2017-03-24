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
	private Long userId;//�û�Id
	
	@Column(name="train_Id")
	private Long trainId; //����Id
	
	@Column(name="beginSite_Id")
	private Long beginSiteId; //�˳�վ
	
	@Column(name="endSite_id")
	private Long endSiteId; //�³�վ
	
	@Column(name="startTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime; //����ʱ��
	
	@Column(name="seatType")
	private Integer seatType;  //ϯ��
	
	@Column(name="seat")
	private String seat;//��λ
	
	@Column(name="price")
	private String price;  //��Ŀ�ĵصļ۸��ȥ����վ�ļ۸�ľ���ֵ
	
	@Column(name="status")
	private String status;//������   �Ѹ���  ��֧�����˳�   ��ȡ��     ���˶�  �ѹر�   �����

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
