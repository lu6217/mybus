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
	public void save(Role role) {
		// TODO Auto-generated method stub
		roleDao.save(role);
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

	
}
