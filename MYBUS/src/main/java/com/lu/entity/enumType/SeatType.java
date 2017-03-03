package com.lu.entity.enumType;

public enum SeatType {
	YZ(1), YW(2), RZ(3), RW(4);

	private Integer type;

	SeatType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

}
