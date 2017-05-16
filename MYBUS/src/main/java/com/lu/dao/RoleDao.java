package com.lu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lu.entity.authority.Role;
import com.lu.util.BaseDAO;
import com.lu.util.DetachedCriteriaBuilder;
import com.lu.util.PagingVO;

@Repository
public class RoleDao extends BaseDAO<Role>{

	public List<Role> getRoleByName(String name) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query=DetachedCriteriaBuilder.instance(Role.class);
		query.addEq("name",name);
		
		return this.select(query);
	}

	public PagingVO searchList(PagingVO pagingVo) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = initQueryCriteria();
		DetachedCriteriaBuilder count = initQueryCriteria();
		return this.selectPagingVO(query, pagingVo, count);
	}

	private DetachedCriteriaBuilder initQueryCriteria() {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = DetachedCriteriaBuilder.instance(Role.class, "role");
		
		return query;
	}

	public Role getRoleById(Long id) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = DetachedCriteriaBuilder.instance(Role.class, "role");
		query.addEq("role.id", id);
		return this.selectTopOne(query);
	}
	
}
