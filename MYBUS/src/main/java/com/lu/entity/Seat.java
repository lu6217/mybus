package com.lu.entity;

public class Seat {

	private Long id;
	
	private Long trainId;
	
	private Long userId;
	
	private Long orderId;
	
	private Long compartmentNumber;//(车厢号)
	
	private Long  seatNumber;//(座位号)

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
	
	
}
