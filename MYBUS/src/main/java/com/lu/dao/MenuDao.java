package com.lu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lu.entity.authority.Menu;
import com.lu.util.BaseDAO;
import com.lu.util.DetachedCriteriaBuilder;

@Repository
public class MenuDao extends BaseDAO<Menu>{

	public List<Menu> getMenus() {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query=DetachedCriteriaBuilder.instance(Menu.class,"menu");
		return this.select(query);
	}

	public List<Menu> getMenusById(Long menuId) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query=DetachedCriteriaBuilder.instance(Menu.class,"menu");
		query.addEq("menu.id", menuId);
		return this.select(query);
	}

	public List<Menu> getMenus(Long[] menuIds) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query=DetachedCriteriaBuilder.instance(Menu.class,"menu");
		if(menuIds!=null){
			for (int i = 0; i < menuIds.length; i++) {
				query.addNe("menu.id", menuIds[i]);
			}
		}
		return this.select(query);
	}

}
