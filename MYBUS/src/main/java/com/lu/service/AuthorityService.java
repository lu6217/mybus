package com.lu.service;

import java.util.List;

import com.lu.entity.authority.Menu;
import com.lu.entity.authority.Role;
import com.lu.util.PagingVO;

public interface AuthorityService {

	boolean checkName(String name);

	void save(Role role);

	PagingVO searchList(PagingVO pagingVo);

	List<Menu> getMenuByRoleId(Long roleId);

}
