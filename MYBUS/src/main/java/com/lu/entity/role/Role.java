package com.lu.entity.role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.lu.entity.menu.Menu;

@Entity
@Table(name = "tb_roles")
@DynamicInsert
@DynamicUpdate
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="name")
	private String name;//角色名称
	
	@Column(name="description")
	private String description;//角色描述
	
	@Column(name="accountTypeId")
	private Long accountTypeId;
	
	//角色所拥有的权限
	@Transient
	private Menu menus;

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

	public Long getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(Long accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public Menu getMenus() {
		return menus;
	}

	public void setMenus(Menu menus) {
		this.menus = menus;
	}

	
}
