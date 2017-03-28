package com.lu.dao;

import org.springframework.stereotype.Repository;

import com.lu.entity.account.User;
import com.lu.entity.vo.UserVo;
import com.lu.util.BaseDAO;
import com.lu.util.DetachedCriteriaBuilder;
import com.lu.util.PagingVO;
@Repository
public class UserDao extends BaseDAO<User>{

	public PagingVO searchList(PagingVO pagingVo, UserVo userVo) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = initQueryCriteria(userVo);
		DetachedCriteriaBuilder count = initQueryCriteria(userVo);
		return this.selectPagingVO(query, pagingVo, count);
	}
		//待修改   可能只需要通过accountID来查询就可以了 查出某个账户中的user
	private DetachedCriteriaBuilder initQueryCriteria(UserVo userVo) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = DetachedCriteriaBuilder.instance(User.class, "user");
//		query.addLikeAny("user.name", userVo.getName());
//		query.addLikeAny("user.address", userVo.getAddress());
//		query.addLikeAny("user.telphone",userVo.getTelphone());
//		query.addLikeAny("user.IDcard",userVo.getIDcard());
//		query.addEq("user.age", userVo.getAge());
//		query.addEq("user.sex", userVo.getSex());
		query.addEq("user.accountId", userVo.getAccountId());
		
		return query;
	}
	
}
