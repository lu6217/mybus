package com.lu.entity.vo;

import java.io.Serializable;

public class ResultVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1543717280642657159L;
	
	private Long id;

	private String name;

	private String description;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
