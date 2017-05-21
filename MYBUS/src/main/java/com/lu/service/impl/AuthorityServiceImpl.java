package com.lu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.dao.AccountType_RoleDao;
import com.lu.dao.MenuDao;
import com.lu.dao.RoleDao;
import com.lu.dao.Role_MenuDao;
import com.lu.entity.authority.Menu;
import com.lu.entity.authority.Role;
import com.lu.entity.authority.Role_Menu;
import com.lu.service.AuthorityService;
import com.lu.util.PagingVO;
@Service
public class AuthorityServiceImpl implements AuthorityService{

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private AccountType_RoleDao accountType_RoleDao;
	
	@Autowired
	private Role_MenuDao role_MenuDao;
	
	@Override
	@Transactional
	public boolean checkName(String name) {
		// TODO Auto-generated method stub
		List<Role> lists=roleDao.getRoleByName(name);
		if(lists!=null && lists.size()!=0){
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public void saveRole(Role role) {
		// TODO Auto-generated method stub
		roleDao.save(role);
	}

	@Override
	@Transactional
	public void saveMenu(Menu menu) {
		// TODO Auto-generated method stub
		menuDao.save(menu);
	}

	@Override
	@Transactional
	public PagingVO searchList(PagingVO pagingVo) {
		// TODO Auto-generated method stub
		PagingVO vo =pagingVo;
		vo=roleDao.searchList(pagingVo);
		return vo;
	}

	@Override
	@Transactional
	public List<Menu> getMenuByRoleId(Long roleId) {
		// TODO Auto-generated method stub
		List<Role_Menu> lists=role_MenuDao.getRole_MenuByRoleId(roleId);
		//先查出role_menu 再在其中去除menu
		if(lists!=null && lists.size()>0){
			List<Menu> menus=new ArrayList<Menu>();
			for (int i = 0; i < lists.size(); i++) {
				menus.add(lists.get(i).getMenu());
			}
			return menus;
		}
		return null;
	}

	@Override
	@Transactional
	public List<Menu> getMenus() {
		// TODO Auto-generated method stub
		List<Menu> menus=menuDao.getMenus();
		if(menus!=null && menus.size()>0){
			return menus;
		}
		return null;
	}

	@Override
	@Transactional
	public Menu getMenuById(Long menuId) {
		// TODO Auto-generated method stub
		List<Menu> menus=menuDao.getMenusById(menuId);
		if(menus!=null && menus.size()>0){
			return menus.get(0);
		}
		return null;
	}

	@Override
	@Transactional
	public void updateMenu(Menu pmenu) {
		// TODO Auto-generated method stub
		menuDao.update(pmenu);
	}

	@Override
	@Transactional
	public Role getRoleById(Long id) {
		// TODO Auto-generated method stub
		Role role=roleDao.getRoleById(id);
		return role;
	}

	@Override
	@Transactional
	public void saveRoleMenu(Role_Menu role_Menu) {
		// TODO Auto-generated method stub
		role_MenuDao.save(role_Menu);
	}

	@Override
	public List<Menu> getMenus(Long id) {
		// TODO Auto-generated method stub
		List<Role_Menu> role_Menus=role_MenuDao.getRole_MenuByRoleId(id);
		Long [] menuIds = null;
		if (role_Menus!=null) {
			menuIds=new Long[role_Menus.size()];
			for (int i = 0; i < role_Menus.size(); i++) {
				menuIds[i]=role_Menus.get(i).getMenuId();
			}
		}
		List<Menu> menus=menuDao.getMenus(menuIds);
		if(menus!=null && menus.size()>0){
			return menus;
		} 
		return null;
	}

	@Override
	@Transactional
	public Boolean delRoleMenu(Long roleId, Long menuId) {
		// TODO Auto-generated method stub
		Role_Menu role_Menu=role_MenuDao.getRole_MenuByRoleIdAndMenuId(roleId,menuId);
		if(role_Menu!=null){
			role_MenuDao.delete(role_Menu);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public Role getRoleByNumber(Long number) {
		// TODO Auto-generated method stub
		Role role= roleDao.getroleByNumber(number);
		if(role!=null)
			return role;
		return null;
	}

	
}
