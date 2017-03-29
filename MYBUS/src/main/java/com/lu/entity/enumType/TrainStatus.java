package com.lu.entity.enumType;

public enum TrainStatus {

	OFF(0), ON(10);//off 已关闭   on 正常使用

	private Integer status;

	TrainStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}
	
}
