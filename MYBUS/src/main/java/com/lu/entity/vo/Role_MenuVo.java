package com.lu.entity.vo;

public class Role_MenuVo {

	private Long roleId;
	
	private String roleName;
	
	private Long[] menulists;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Long[] getMenulists() {
		return menulists;
	}

	public void setMenulists(Long[] menulists) {
		this.menulists = menulists;
	}
	
	
}
