package com.lu.entity.authority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "tb_menu")
@DynamicInsert
@DynamicUpdate
public class Menu {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="name")
	private String name;//菜单名称
	
	@Column(name="url")
	private String url;//菜单URL
	
	@Column(name="icon")
	private String icon;//菜单图标
	
	@Column(name="upperlevelmeuId")
	private long upperLevelMenuId;//上级菜单id
	
	@Column(name="level")
	private Integer level;//菜单的层次
	
	@Column(name="leaf")
	private Boolean leaf;//是否为叶子节点
	
//	@Column(name="roleId")
//	private Long roleId;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public long getUpperLevelMenuId() {
		return upperLevelMenuId;
	}

	public void setUpperLevelMenuId(long upperLevelMenuId) {
		this.upperLevelMenuId = upperLevelMenuId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}
	
}
