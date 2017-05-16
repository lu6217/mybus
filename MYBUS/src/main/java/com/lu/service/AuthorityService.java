package com.lu.service;

import java.util.List;

import com.lu.entity.authority.Menu;
import com.lu.entity.authority.Role;
import com.lu.entity.authority.Role_Menu;
import com.lu.util.PagingVO;

public interface AuthorityService {

	boolean checkName(String name);

	void saveRole(Role role);

	PagingVO searchList(PagingVO pagingVo);

	List<Menu> getMenuByRoleId(Long roleId);

	List<Menu> getMenus();

	Menu getMenuById(Long menuId);

	void updateMenu(Menu pmenu);

	void saveMenu(Menu menu);

	Role getRoleById(Long id);

	void saveRoleMenu(Role_Menu role_Menu);

}
