package com.lu.service;

import com.lu.entity.account.User;
import com.lu.entity.vo.UserVo;
import com.lu.util.PagingVO;

public interface UserService {

	public void saveOrUpdateUser(User user);

	public PagingVO searchList(PagingVO pagingVo, UserVo userVo);

	public User getUserById(Long id);

}
