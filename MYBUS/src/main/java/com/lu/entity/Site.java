package com.lu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="site")
@DynamicInsert
@DynamicUpdate
public class Site {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String priceL;
	
	private String priceR;
	
	private String direction;

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

	public String getPriceL() {
		return priceL;
	}

	public void setPriceL(String priceL) {
		this.priceL = priceL;
	}

	public String getPriceR() {
		return priceR;
	}

	public void setPriceR(String priceR) {
		this.priceR = priceR;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	} 
	
	
}
