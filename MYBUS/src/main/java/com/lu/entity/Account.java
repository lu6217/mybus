package com.lu.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name = "tb_account")
@DynamicInsert
@DynamicUpdate
public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4346170139689800818L;

	public static final long GENERAL_USERTYPE = 10L;
	public static final long MANAGE_USERTYPE=20L;
	public static final long ADMIN_USERTYPE=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;//账户名
	
	private String password;//密码
	
	private Long type=GENERAL_USERTYPE; //账户类型
	
	@Transient
	private List<User> users; //用户
	
	@Transient
	private List<Order> orders;//订单

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

}
