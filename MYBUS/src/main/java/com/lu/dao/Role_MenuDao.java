package com.lu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lu.entity.authority.Role_Menu;
import com.lu.util.BaseDAO;
import com.lu.util.DetachedCriteriaBuilder;

@Repository
public class Role_MenuDao extends BaseDAO<Role_Menu>{

	public List<Role_Menu> getRole_MenuByRoleId(Long roleId) {
		// TODO Auto-generated method stub
		
		DetachedCriteriaBuilder builder = DetachedCriteriaBuilder.instance(Role_Menu.class,"role_menu");
		builder.leftJoin("role_menu.menu", "menu");
		builder.addEq("role_menu.roleId", roleId);
		return this.select(builder);
	}

}
