package com.lu.service;

import java.util.List;

import com.lu.entity.account.User;
import com.lu.entity.vo.UserVo;
import com.lu.util.PagingVO;

public interface UserService {

	public void saveOrUpdateUser(User user);

	public PagingVO searchList(PagingVO pagingVo, UserVo userVo);

	public User getUserById(Long id);

	public void delUser(User user);

	public List<User> getUserByAccountId(Long accountId);

	public boolean checkIdCard(String name);

	public User getUserByIdCard(String iDcard);

}
