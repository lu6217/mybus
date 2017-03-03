package com.lu.entity.enumType;

public enum TrainStatus {

	OFF(0), ON(10);//off ½ûÓÃ   on¿ÉÓÃ

	private Integer status;

	TrainStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}
	
}
