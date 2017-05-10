package com.lu.entity.seat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="tb_seat")
@DynamicInsert
@DynamicUpdate
public class Seat {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="trainId")
	private Long trainId;
	
	@Column(name="userId")
	private Long userId;
	
	@Column(name="orderId")
	private Long orderId;
	
	@Column(name="compartmentNumber")
	private Long compartmentNumber;//(车厢号)
	
	@Column(name="seatNumber")
	private Long  seatNumber;//(座位号)
	
	@Column(name="status")
	private Long status=0L; //0和1

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCompartmentNumber() {
		return compartmentNumber;
	}

	public void setCompartmentNumber(Long compartmentNumber) {
		this.compartmentNumber = compartmentNumber;
	}

	public Long getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Long seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}
	
	
}
