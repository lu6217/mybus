package com.lu.entity.vo;

public class MenuVo {

	private String name;
	
	private String url;
	
	private String icon;
	
	private Long upperLevelMenuId;
	
	private String level;
	
	private Boolean leaf;
	
	private String item;

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

	public Long getUpperLevelMenuId() {
		return upperLevelMenuId;
	}

	public void setUpperLevelMenuId(Long upperLevelMenuId) {
		this.upperLevelMenuId = upperLevelMenuId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
}
